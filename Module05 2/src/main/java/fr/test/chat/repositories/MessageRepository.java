package fr.test.chat.repositories;

import fr.test.chat.models.Message;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(Long id) throws SQLException, ParseException;
}