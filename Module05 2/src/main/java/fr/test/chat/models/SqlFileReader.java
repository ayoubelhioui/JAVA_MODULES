package fr.test.chat.models;

import java.io.IOException;
import java.util.List;

public interface SqlFileReader {
    List<String> readQueries() throws IOException;
}