package fr.test.exceptions;

import java.sql.SQLException;

public class EntityNotFoundException extends SQLException {
    public EntityNotFoundException () {
        super("Entity Not Found");
    }
}
