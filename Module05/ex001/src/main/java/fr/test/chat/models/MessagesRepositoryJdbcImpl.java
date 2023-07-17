package main.java.fr.test.chat.models;

import java.util.Optional;
import java.sql.Connection;
import fr.test.chat.repositories.MessagesRepository;
import javax.sql.DataSource;
import java.sql.SQLException;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource datasource;

    public MessagesRepositoryJdbcImpl (DataSource dataSource) {
        this.datasource = dataSource;
        System.out.println("connected successfully");
    }

    public Optional<Messages> findById(Long id) {
        return Optional.of((new Messages()));
    }

}