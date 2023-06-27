package main.src.java.chat;

import main.src.java.chat.DatabaseManager;

import javax.xml.crypto.Data;
import java.sql.SQLException;

class Program {
    public static void main(String[] args) {
        try{
            DatabaseManager databaseManager = DatabaseManager.getInstance();
            databaseManager.connect();
        }
        catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}