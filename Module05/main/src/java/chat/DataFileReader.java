package main.src.java.chat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import main.src.java.chat.SqlFileReader;

class DataFileReader implements SqlFileReader {

    static final private String filePath = "/home/ael-hiou/IdeaProjects/JAVA_MODULES/Module05/main/src/resources/data.sql";
    static private BufferedReader bufferedReader;
    static private DataFileReader instance;
    private List<String> queriesList;


    private DataFileReader() throws FileNotFoundException {
        this.queriesList = new LinkedList<>();
        bufferedReader = new BufferedReader(new FileReader(filePath));
}

    public static DataFileReader getInstance() throws FileNotFoundException{
        if (instance == null)
            return (new DataFileReader());
        return (instance);
}

    public void readQueriesFromFile() throws IOException {
        String buffer = "";
        String line;

        while ((line = this.bufferedReader.readLine()) != null) {
            buffer += line;
            if (line.contains(";")) {
                this.queriesList.add(buffer);
                buffer = "";
            }
        }
    }

    public List<String> getQueriesList() {
        return (this.queriesList);
    }
}