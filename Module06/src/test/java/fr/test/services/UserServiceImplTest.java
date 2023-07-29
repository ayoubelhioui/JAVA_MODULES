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
        User user2 = new User(2, "biba", "khawa", false);
        when(userRepository.findByLogin("helloWorld")).thenReturn(user);
        when(userRepository.findByLogin("imad")).thenReturn(user1);
        when(userRepository.findByLogin("biba")).thenReturn(user2);
        boolean isAuthenticate = this.userService.authenticate("helloWorld", "sdjf");
        boolean isAuthenticate2 = this.userService.authenticate("imad", "dtrab");
        boolean isAuthenticate3 = this.userService.authenticate("biba", "khawa");
        verify(this.userRepository, times(1)).findByLogin("helloWorld");
        verify(this.userRepository, times(1)).findByLogin("imad");
        verify(this.userRepository, times(1)).findByLogin("biba");
        assertTrue(isAuthenticate);
        assertTrue(isAuthenticate2);
        assertTrue(isAuthenticate3);
    }

    @Test
    public void authenticateForIncorrectLogin() throws EntityNotFoundException {
        when(userRepository.findByLogin("helalo")).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, ()-> this.userService.authenticate("helalo", "helloWorld"));
        verify(this.userRepository, times(1)).findByLogin("helalo");
        when(userRepository.findByLogin("imad")).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, ()-> this.userService.authenticate("imad", "helloWorld"));
        verify(this.userRepository, times(1)).findByLogin("imad");
        when(userRepository.findByLogin("younes")).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, ()-> this.userService.authenticate("younes", "helloWorld"));
        verify(this.userRepository, times(1)).findByLogin("younes");

    }

    @Test
    public void authenticateForIncorrectPassword() throws EntityNotFoundException, AlreadyAuthenticatedException {
        User user = new User(1, "helloWorld", "sdjf", false);
        User user1 = new User(2, "imad", "dtrab", false);
        User user2 = new User(2, "biba", "khawa", false);
        when(userRepository.findByLogin("helloWorld")).thenReturn(user);
        when(userRepository.findByLogin("imad")).thenReturn(user1);
        when(userRepository.findByLogin("biba")).thenReturn(user2);
        boolean isAuthenticate = this.userService.authenticate("helloWorld", "sd");
        boolean isAuthenticate2 = this.userService.authenticate("imad", "dc");
        boolean isAuthenticate3 = this.userService.authenticate("biba", "cv");
        verify(this.userRepository, times(1)).findByLogin("helloWorld");
        verify(this.userRepository, times(1)).findByLogin("imad");
        verify(this.userRepository, times(1)).findByLogin("biba");
        assertFalse(isAuthenticate);
        assertFalse(isAuthenticate2);
        assertFalse(isAuthenticate3);
    }
}