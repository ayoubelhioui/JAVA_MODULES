package main.src.java.chat;

import java.sql.*;
import java.sql.DriverManager;
import java.util.List;

class DatabaseManager{

    private String url;
    private String username;
    private String password;
    private static DatabaseManager instance;
    private static Connection connection;
    Statement statement;

    public DatabaseManager() {
        this.url = "jdbc:postgresql://localhost:5432/mydb";
        this.username = "postgres";
        this.password = "ayoub";
    }

    static DatabaseManager getInstance() {
        if (instance == null)
            return (new DatabaseManager());
        return (instance);
    }

    public void connect() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(this.url, this.username, this.password);
        System.out.println("connected");
        this.statement = connection.createStatement();
    }

    public void executeQueries(List<String> queries) throws SQLException{
       for(int i = 0; i < queries.size(); i++)
           this.statement.execute(queries.get(i));
    }

    public void disconnect() throws SQLException{
        connection.close();
        System.out.println("disconnected");
    }
}