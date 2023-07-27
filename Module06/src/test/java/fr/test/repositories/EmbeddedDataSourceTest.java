package fr.test.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
    DataSource dataSource;

    public void init() {
         this.dataSource = new EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.HSQL)  // Use HSQL as embedded database.
        .addScripts("schema.sql", "data.sql")
        .build();
    }

    @Test()
    public void getConnectionTest() throws SQLException {
        Connection connection = this.dataSource.getConnection();
    }
}
