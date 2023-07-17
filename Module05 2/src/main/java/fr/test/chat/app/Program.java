package fr.test.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.test.chat.models.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

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
            queryExecutor.execute(schemaQueries);
            queryExecutor.executeUpdate(dataQueries);
            queryExecutor.executeQuery();
//            MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(dataSource, queryExecutor);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
