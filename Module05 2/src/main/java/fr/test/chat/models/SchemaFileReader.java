package fr.test.chat.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SchemaFileReader implements SqlFileReader {

    final static private String filePath = "/Users/ael-hiou/Desktop/J/Module05 2/src/main/resources/schema.sql";
    private BufferedReader bufferedReader;
    static private SchemaFileReader instance;
    private List<String> queriesList;

    private SchemaFileReader() throws FileNotFoundException {
        this.queriesList = new LinkedList<>();
        this.bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public static SchemaFileReader getInstance() throws FileNotFoundException {
        if (instance == null)
            instance = new SchemaFileReader();
        return (instance);
    }
    
    public List<String> readQueries() throws IOException {
        String buffer = "";
        String line;

        while ((line = this.bufferedReader.readLine()) != null) {
            buffer += line;
            if (line.contains(")") && line.length() == 1)
            {
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