package fr.test.chat.repositories;

import fr.test.chat.models.Room;
import java.sql.SQLException;
import java.util.Optional;

public interface RoomRepository{
    Optional<Room> findById(Long id) throws SQLException;
}