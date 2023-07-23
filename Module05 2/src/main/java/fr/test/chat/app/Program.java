package fr.test.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.test.chat.models.*;
import fr.test.chat.repositories.implementation.MessageRepositoryJdbcImpl;
import fr.test.chat.repositories.implementation.RoomRepositoryJdbcImpl;
import fr.test.chat.repositories.implementation.UserRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        try {
            HikariConfig config = new HikariConfig();
            SqlFileReader schemaFileReader = SchemaFileReader.getInstance();
            SqlFileReader dataFileReader = DataFileReader.getInstance();
            List<String> schemaQueries = schemaFileReader.readQueries();
            List<String> dataQueries = dataFileReader.readQueries();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
            config.setUsername("postgres");
            config.setPassword("ayoub");
            config.setDriverClassName("org.postgresql.Driver");
            DataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            QueryExecutor queryExecutor = new QueryExecutor(connection);
            queryExecutor.execute(schemaQueries); // executing create tables queries.
            queryExecutor.executeUpdate(dataQueries); // executing Insert, Update, Delete queries.
            RoomRepositoryJdbcImpl roomRepositoryJdbc = new RoomRepositoryJdbcImpl(queryExecutor);
            UserRepositoryJdbcImpl userRepositoryJdbc = new UserRepositoryJdbcImpl(queryExecutor);
            MessageRepositoryJdbcImpl MessageRepositoryJdbc = new MessageRepositoryJdbcImpl(dataSource,
                    queryExecutor, userRepositoryJdbc, roomRepositoryJdbc);

//            Optional<Message> message = MessageRepositoryJdbc.findById(1L);
//            if (message.isPresent()) {
//                Message messages = message.get();
//                User newUser = new User(3, "nologin", "helloWorld", new ArrayList<>(), new ArrayList<>());
//                Room newRoom = new Room(20, "Ayuub'sRoom", newUser, new ArrayList<>());
//                messages.setText("++++++++++++++++");
//                messages.setDate(null);
//                messages.setAuthor(newUser);
//                messages.setRoom(newRoom);
//                MessageRepositoryJdbc.update(messages);
//            }
//            User creator = new User(1L, "user", "user", new ArrayList<>(), new ArrayList<>());
//            User author = creator;
//            Room room = new Room(200L, "room", creator, new ArrayList<>());
//            Message Message = new Message(null, author, room, "_---------------________", LocalDateTime.now());
//            MessageRepositoryJdbc.save(Message);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
