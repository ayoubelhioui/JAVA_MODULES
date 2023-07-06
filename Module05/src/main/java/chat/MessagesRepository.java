package src.main.java.chat;

import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(Long id);
}
