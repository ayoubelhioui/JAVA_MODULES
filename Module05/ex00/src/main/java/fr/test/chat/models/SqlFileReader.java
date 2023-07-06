package fr.test.chat.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SqlFileReader {
    void readQueries() throws IOException;
}