package fr.test.chat.exceptions;

public class NotSavedSubEntityException extends RuntimeException{

    public NotSavedSubEntityException(final String message) {
        super(message);
    }
}
