package fr.test.chat.repositories.implementation;

import fr.test.chat.exceptions.NotSavedSubEntityException;
import fr.test.chat.models.QueryExecutor;
import fr.test.chat.models.User;
import fr.test.chat.repositories.UserRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {
    private QueryExecutor queryExecutor;

//    private UserRepositoryJdbcImpl() {}
    public UserRepositoryJdbcImpl(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    public Optional<User> findById(Long id) throws SQLException, NotSavedSubEntityException {
        final String query = "SELECT * FROM \"User\" WHERE id = " + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
        if (!resultSet.next())
            return (Optional.ofNullable(null));
        return Optional.of((new User(id, resultSet.getString("login"), resultSet.getString("password"), new ArrayList<>(), new ArrayList<>())));
    }
}
