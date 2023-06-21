package CustomExceptions;
import CustomExceptions.UserNotFoundException;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}