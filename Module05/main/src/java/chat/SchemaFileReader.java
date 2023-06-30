package main.src.java.chat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import main.src.java.chat.SqlFileReader;

class SchemaFileReader implements SqlFileReader {

    final static private String filePath = "/home/ael-hiou/IdeaProjects/JAVA_MODULES/Module05/main/src/resources/schema.sql";
    private BufferedReader bufferedReader;
    static private SchemaFileReader instance;
    private List<String> queriesList;

    private SchemaFileReader() throws FileNotFoundException {
        this.queriesList = new LinkedList<>();
        this.bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public static SchemaFileReader getInstance() throws FileNotFoundException{
        if (instance == null)
            return (new SchemaFileReader());
        return (instance);
    }

    public void readQueriesFromFile() throws IOException {
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
    }

    public List<String> getQueriesList() {
        return (this.queriesList);
    }
}