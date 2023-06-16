package ex02;

interface UsersList{
    void add(User newUser);
    User getById(int id) throws UserNotFoundException;
    User getByIndex(int index);
    int getCount();
}