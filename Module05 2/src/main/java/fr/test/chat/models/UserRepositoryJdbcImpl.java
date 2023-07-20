package fr.test.chat.models;

import fr.test.chat.repositories.UserRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {
    private DataSource datasource;
    private Statement statement;
    private QueryExecutor queryExecutor;

//    private UserRepositoryJdbcImpl() {};
//    public UserRepositoryJdbcImpl() {
//
//    }
    public Optional<User> findById(Long id) throws SQLException {
        final String query = "SELECT * FROM \"User\" INNER JOIN chatroom ON \"User\".id = chatroom.user_id WHERE \"User\".id =" + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
//        if (!resultSet.next())
//            return (Optional.ofNullable(null));
//        long author = resultSet.getLong("author");
//        long room   = resultSet.getLong("room");
//        String date = resultSet.getString("date");
//        String text = resultSet.getString("text");
            return (Optional.of(new User()));
//        return Optional.of(new Messages(id, author, room, text, dateFormat.parse(date)));
    }
}
