package fr.test.chat.models;

import fr.test.chat.repositories.MessagesRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource datasource;
    private Statement statement;
    private QueryExecutor queryExecutor;

    public MessagesRepositoryJdbcImpl (DataSource dataSource, QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
        this.datasource = dataSource;
        System.out.println("connected successfully");
    }

    public Optional<Messages> findById(Long id) throws SQLException {
        List<String> queriesList = new LinkedList<>();
        String query = "SELECT * FROM Messages WHERE id = " + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
        resultSet.next();
        return Optional.of((new Messages(id, resultSet.getString())));
    }

}