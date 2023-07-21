package fr.test.chat.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader implements SqlFileReader {

    static final private String filePath = "/Users/ael-hiou/Desktop/J/Module05 2/src/main/resources/data.sql";
    private BufferedReader bufferedReader;
    static private DataFileReader instance;
    private List<String> queriesList;

    private DataFileReader() throws FileNotFoundException {
        this.queriesList = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public static DataFileReader getInstance() throws FileNotFoundException {
        if (instance == null)
            instance  = new DataFileReader();
        return (instance);
    }

    public List<String> readQueries() throws IOException {
        String buffer = "";
        String line;
        while ((line = this.bufferedReader.readLine()) != null) {
            buffer += line;
            if (line.contains(";")) {
                this.queriesList.add(buffer);
                buffer = "";
            }
        }
        return (this.queriesList);
    }

    public List<String> getQueriesList() {
        return (this.queriesList);
    }
}