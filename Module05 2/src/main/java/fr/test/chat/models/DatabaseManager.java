package fr.test.chat.models;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseManager{
    private static DatabaseManager instance;
    private static Connection connection;
    private static PGSimpleDataSource dataSource;
    Statement statement;

    public DatabaseManager() {
        dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:postgresql://localhost:5432/mydb");
        dataSource.setUser("postgres");
        dataSource.setPassword("ayoub");
    }

    public static DatabaseManager getInstance() {
        if (instance == null)
            instance  = new DatabaseManager();
        return (instance);
    }

    public void connect() throws SQLException {
        connection = dataSource.getConnection();
        System.out.println("connected");
        this.statement = connection.createStatement();
    }

    public void executeQueries(List<String> queries) throws SQLException {
       for(int i = 0; i < queries.size(); i++)
           this.statement.execute(queries.get(i));
    }

    public void disconnect() throws SQLException{
        connection.close();
        System.out.println("disconnected");
    }
}