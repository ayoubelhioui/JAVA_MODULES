package fr.test.repositories;

import fr.test.exceptions.EntityNotFoundException;
import fr.test.models.User;

public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl() { }

    public User findByLogin(String login) throws EntityNotFoundException{
        if (login.contains("a")) {
            throw new EntityNotFoundException();
        }
        return (new User());
    }

    public void update(User user) throws EntityNotFoundException{
        if (user.getId() % 2 == 0)
            throw new EntityNotFoundException();

    }
}
