package main.src.java.chat;

import java.sql.DriverManager;
class DatabaseManager{
    private String url;
    private String username;
    private String password;
    private static DatabaseManager instance;

    public DatabaseManager() { }

    static DatabaseManager getInstance() {
        if (instance == null)
            return (new DatabaseManager());
        return (instance);
    }

    public void connect() {

    }
}