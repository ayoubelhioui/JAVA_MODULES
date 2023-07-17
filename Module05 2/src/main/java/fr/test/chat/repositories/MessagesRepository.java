package fr.test.chat.repositories;

import fr.test.chat.models.Messages;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(Long id) throws SQLException;
}
