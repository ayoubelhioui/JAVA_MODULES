package fr.test.chat.repositories.implementation;

import fr.test.chat.exceptions.NotSavedSubEntityException;
import fr.test.chat.models.Message;
import fr.test.chat.models.QueryExecutor;
import fr.test.chat.models.Room;
import fr.test.chat.models.User;
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
    private static UserRepositoryJdbcImpl userRepositoryJdbc;
    private static RoomRepositoryJdbcImpl roomRepositoryJdbc;

    public MessageRepositoryJdbcImpl (DataSource dataSource, QueryExecutor queryExecutor,
                                      UserRepositoryJdbcImpl userRepositoryJdbcs, RoomRepositoryJdbcImpl roomRepositoryJdbcs) {
        dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.queryExecutor = queryExecutor;
        this.datasource = dataSource;
        userRepositoryJdbc = userRepositoryJdbcs;
        roomRepositoryJdbc = roomRepositoryJdbcs;
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

    public void save(Message message) throws SQLException, NotSavedSubEntityException {
        User messageOwner = message.getAuthor();
        Room messageRoom = message.getRoom();
        if (!userRepositoryJdbc.findById(messageRoom.getId()).isPresent())
            throw new NotSavedSubEntityException("The user subentity is not exist!");
        if (!roomRepositoryJdbc.findById(messageRoom.getId()).isPresent())
            throw new NotSavedSubEntityException("The room subentity is not exist!");
        List<String> queryList = new ArrayList<>();
        final String query = "INSERT INTO Message (text, datetime, author, room)\n" +
                "VALUES ('" + message.getText() + "', '" + message.getDate() + "', " + messageOwner.getId() + ", " +
                messageRoom.getId() + ");";
        queryList.add(query);
        this.queryExecutor.executeUpdate(queryList);
    }
}
