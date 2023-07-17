package main.java.fr.test.chat.models;

import java.sql.*;
import java.util.List;
import org.postgresql.ds.PGSimpleDataSource;

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

    public void connect() throws SQLException, ClassNotFoundException {
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