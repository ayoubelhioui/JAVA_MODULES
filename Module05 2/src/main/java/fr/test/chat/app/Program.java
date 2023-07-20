package fr.test.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.test.chat.models.*;

import javax.sql.DataSource;
import java.sql.Connection;
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
//            MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(dataSource, queryExecutor);
//            Optional<Messages> message = messagesRepositoryJdbc.findById(9L);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
