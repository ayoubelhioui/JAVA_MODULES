package fr.test.chat.models;

import fr.test.chat.repositories.MessageRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepositoryJdbcImpl implements MessageRepository {
    private DataSource datasource;
    private Statement statement;
    private final QueryExecutor queryExecutor;
    private static DateTimeFormatter dateFormat;

    public MessageRepositoryJdbcImpl (DataSource dataSource, QueryExecutor queryExecutor) {
        dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.queryExecutor = queryExecutor;
        this.datasource = dataSource;
        System.out.println("connected successfully");
    }

    private void printMessageInfo(Message message) {
        System.out.println("Message { :");
        System.out.println("    id " + message.getId() + ",");
        message.getAuthor().printUserInfo();
        message.getRoom().printRoomInfo();
        System.out.println("    text = \"" + message.getText() + "\"");
        System.out.println("    date \"" + message.getDate() + "\"");
        System.out.println(" }");
    }

    private Message extractMessageInfo(ResultSet resultSet) throws SQLException, ParseException{
        User user = new User(resultSet.getLong("author"), resultSet.getString("login"),
        resultSet.getString("password"), new ArrayList<>(), new ArrayList<>());
        Room room = new Room(resultSet.getLong("room"), resultSet.getString("name"), user, new ArrayList<>());
        long id = resultSet.getLong("id");
        String date = resultSet.getString("datetime");
        String text = resultSet.getString("text");
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateFormat);
        return (new Message(id, user, room, text, localDateTime));
    }

    public Optional<Message> findById(Long id) throws SQLException, ParseException {
        final String query = "SELECT * FROM Message INNER JOIN \"User\" ON \"User\".id = Message.author INNER JOIN Room ON Room.owner = \"User\".id WHERE Message.id = " + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
        if (!resultSet.next())
        {
            System.out.println("The User with id " + id + " is not exist !");
            return (Optional.ofNullable(null));
        }
        Message message = this.extractMessageInfo(resultSet);
        this.printMessageInfo(message);
        return Optional.of(message);
    }

    public void save(Message message) throws SQLException{
        List<String> queryList = new ArrayList<String>();
        final String query = "INSERT INTO Message (text, date, author, room)\n" +
                "VALUES ('" + message.getText() + "', '" + message.getDate() + "', " + message.getAuthor().getId() + ", " +
                message.getRoom().getId() + ");";
        queryList.add(query);
        this.queryExecutor.executeUpdate(queryList);
        System.out.println(query);
    }
}
