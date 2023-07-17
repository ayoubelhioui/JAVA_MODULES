package fr.test.chat.repositories;

import fr.test.chat.models.Messages;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(Long id);
}
