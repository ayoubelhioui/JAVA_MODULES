package fr.test.chat.repositories.implementation;

import fr.test.chat.models.QueryExecutor;
import fr.test.chat.models.Room;
import fr.test.chat.models.User;
import fr.test.chat.repositories.RoomRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class RoomRepositoryJdbcImpl implements RoomRepository {

    private final QueryExecutor queryExecutor;


    public RoomRepositoryJdbcImpl(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    public Optional<Room> findById(Long id) throws SQLException {
        final String query = "SELECT login FROM Room INNER JOIN \"User\" ON \"User\".id = Room.owner WHERE id = " + id;
        ResultSet resultSet = this.queryExecutor.executeQuery(query);
        if (!resultSet.next())
            return (Optional.ofNullable(null));
        User owner = new User(resultSet.getLong("author"), resultSet.getString("login"),
                resultSet.getString("password"), new ArrayList<>(), new ArrayList<>());
        return Optional.of(new Room(id, resultSet.getString("name"), owner, new ArrayList<>()));
    }

}
