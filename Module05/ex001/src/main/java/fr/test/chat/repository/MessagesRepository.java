package fr.test.chat.repository;

import fr.test.chat.models.Messages;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(Long id);
}
