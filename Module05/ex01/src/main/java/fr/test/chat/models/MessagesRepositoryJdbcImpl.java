package fr.test.chat.models;

import java.util.Optional;
import fr.test.chat.repositories.MessagesRepository;

class MessageRepositoryJdbcImpl implements MessagesRepository{

    public MessageRepositoryJdbcImpl () {

    }
    public Optional<Messages> findById(Long id) {
        return Optional.of((new Messages()));
    }

}