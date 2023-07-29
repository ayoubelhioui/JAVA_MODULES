package fr.test.services;

import fr.test.exceptions.AlreadyAuthenticatedException;
import fr.test.exceptions.EntityNotFoundException;
import fr.test.models.User;
import fr.test.repositories.UserRepository;

import java.util.Objects;

public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String login, String password) throws EntityNotFoundException, AlreadyAuthenticatedException {
        User user = this.userRepository.findByLogin(login);
        if (!Objects.equals(user.getPassword(), password))
            return (false);
        if (user.isAuthenticate())
            throw new AlreadyAuthenticatedException();
        user.setAuthenticate(true);
        this.userRepository.update(user);
        return (true);
    }
}
