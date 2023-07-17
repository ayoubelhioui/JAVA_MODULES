package fr.test.chat.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class QueryExecutor {
    private Statement statement;

    public QueryExecutor (Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public void execute(List<String> queries) throws SQLException {
        for (String query : queries)
            System.out.println(this.statement.execute(query));
    }

    public void executeUpdate(List<String> queries) throws SQLException {
        for (String query : queries) {
            System.out.println(this.statement.executeUpdate(query));
        }
    }

    public ResultSet executeQuery(String Query) throws SQLException {
        return (this.statement.executeQuery(Query));
    }
}
