package fr.test.chat.repositories;

import fr.test.chat.models.User;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id) throws SQLException, ParseException;
    List<User> findAll(int page, int size);
}