package fr.test.services;

import fr.test.exceptions.AlreadyAuthenticatedException;
import fr.test.exceptions.EntityNotFoundException;
import fr.test.exceptions.IllegalNumberException;
import fr.test.models.User;
import fr.test.repositories.UserRepository;
import fr.test.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    UserRepositoryImpl userRepository = mock(UserRepositoryImpl.class);
    UserServiceImpl userService = new UserServiceImpl(userRepository);


//    public init()
    @Test
    public void authenticateForCorrectTest() throws EntityNotFoundException, AlreadyAuthenticatedException {
        User user = new User(1, "helloWorld", "sdjf", false);
        User user1 = new User(2, "imad", "dtrab", false);
        when(userRepository.findByLogin("helloWorld")).thenReturn(user);
        verify(this.userRepository, times(1)).findByLogin("helloWorld");
        boolean isAuthenticate = this.userService.authenticate("helloWorld", "sdjf");
//        boolean isAuthenticate2 = this.userService.authenticate("imad", "dtrab");
        assertTrue(isAuthenticate);
//        assertTrue(isAuthenticate2);
    }

    @Test
    public void authenticateForIncorrectLogin() throws EntityNotFoundException {
        when(userRepository.findByLogin("helalo")).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, ()-> this.userService.authenticate("helalo", "helloWorld"));
    }

//    @Test
//    public void authenticateForIncorrectPassword() throws EntityNotFoundException, AlreadyAuthenticatedException {
//        User user = new User(1, "helloWorld", "sdjf", false);
//        when(userRepository.findByLogin("helloWorld")).thenReturn(user);
//        boolean isAuthenticate = this.userService.authenticate("helloWorld", "incorrectPassword");
//        verify(this.userRepository, times(1)).findByLogin("helloWorld");
//        assertFalse(isAuthenticate);
//    }
}