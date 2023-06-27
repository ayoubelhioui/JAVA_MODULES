package main.src.java.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;

class DatabaseManager{

    private String url;
    private String username;
    private String password;
    private static DatabaseManager instance;

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
        Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
        if (connection.isValid(5)) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to connect to the database");
        }
        connection.close();
    }
}