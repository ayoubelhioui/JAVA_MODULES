package fr.test.chat.models;

import fr.test.chat.repositories.MessagesRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource datasource;
    private Statement statement;
    private QueryExecutor queryExecutor;
    private static SimpleDateFormat dateFormat;

    public MessagesRepositoryJdbcImpl (DataSource dataSource, QueryExecutor queryExecutor) {
        dateFormat = new SimpleDateFormat("yyyy-MM-d");
        this.queryExecutor = queryExecutor;
        this.datasource = dataSource;
        System.out.println("connected successfully");
    }

    public Optional<Messages> findById(Long id) throws SQLException, ParseException {
        final String query = "SELECT * FROM messages INNER JOIN \"User\" ON messages.author = \"User\".id WHERE messages.id = " + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
        if (!resultSet.next())
            return (Optional.ofNullable(null));
        long author = resultSet.getLong("author");
        long room   = resultSet.getLong("room");
        String date = resultSet.getString("date");
        String text = resultSet.getString("text");
        return Optional.of(new Messages(id, author, room, text, dateFormat.parse(date)));
    }

}
