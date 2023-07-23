package fr.test.chat.repositories;

import fr.test.chat.exceptions.NotSavedSubEntityException;
import fr.test.chat.models.Message;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(Long id) throws SQLException, ParseException;
    void update(Message message) throws SQLException ;
    void save(Message message) throws SQLException, NotSavedSubEntityException;
}