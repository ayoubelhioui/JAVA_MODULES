package main.src.java.chat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SqlFileReader {
    void readQueriesFromFile() throws IOException;
}