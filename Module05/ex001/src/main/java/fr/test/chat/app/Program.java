package main.java.fr.test.chat.app;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import main.java.fr.test.chat.models.MessagesRepositoryJdbcImpl;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("postgres");
        config.setPassword("ayoub");
        config.setDriverClassName("org.postgresql.Driver");
        DataSource dataSource = new HikariDataSource(config);
        try (Connection connection = dataSource.getConnection()) {
            MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(dataSource);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
