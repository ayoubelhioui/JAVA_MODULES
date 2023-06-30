package main.src.java.chat;

import main.src.java.chat.DatabaseManager;
import main.src.java.chat.SchemaFileReader;
import main.src.java.chat.DataFileReader;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

class Program {
    public static void main(String[] args) {
        List<String> queriesList;
        try {
            DatabaseManager databaseManager = DatabaseManager.getInstance();
            SchemaFileReader schemaFileReader = SchemaFileReader.getInstance();
            DataFileReader dataFileReader = DataFileReader.getInstance();
            databaseManager.connect();
            schemaFileReader.readQueriesFromFile();
            queriesList = schemaFileReader.getQueriesList();
            databaseManager.executeQueries(queriesList);
            queriesList.clear();
            dataFileReader.readQueriesFromFile();
            queriesList = dataFileReader.getQueriesList();
            databaseManager.executeQueries(queriesList);
            databaseManager.disconnect();
        }
        catch(SQLException | ClassNotFoundException | IOException | NullPointerException e) {
            System.out.println(e);
        }
    }
}