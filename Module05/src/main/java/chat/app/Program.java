package src.main.java.chat.app;


import src.main.java.chat.DatabaseManager;
import src.main.java.chat.SchemaFileReader;
import src.main.java.chat.DataFileReader;

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
            schemaFileReader.readQueries();
            queriesList = schemaFileReader.getQueriesList();
            databaseManager.executeQueries(queriesList);
            queriesList.clear();
            dataFileReader.readQueries();
            queriesList = dataFileReader.getQueriesList();
            databaseManager.executeQueries(queriesList);
            databaseManager.disconnect();
        }
        catch(SQLException | ClassNotFoundException | IOException | NullPointerException e) {
            System.out.println(e);
        }
    }
}