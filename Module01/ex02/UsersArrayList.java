package ex02;

import java.util.ArrayList;

class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}

class UsersArrayList implements UsersList{
    private static User[] Array;
    private static int filledSize;

    UsersArrayList() {
        Array = new User[10];
        filledSize = 0;
    }

    private void newArray() {
        int ArrayLength = Array.length;
        User[] savior = new User[ArrayLength];
        for (int i = 0; i < Array.length; i++)
            savior[i] = Array[i];
        Array = new User[ArrayLength + (ArrayLength / 2)];
        for (int i = 0; i < savior.length; i++)
            Array[i] = savior[i];
    }

    public void add(User newUser){
        if (filledSize == Array.length)
            this.newArray();
        Array[filledSize++] = newUser;
    };

    public User getById(int id) throws UserNotFoundException{
        for (int i = 0; i < filledSize; i++)
            if (Array[i].getId() == id)
                return (Array[i]);
        throw new UserNotFoundException("The user you are looking for is not found.");
    };

    public User getByIndex(int index){
        if (index > filledSize - 1 || index < 0)
            throw new ArrayIndexOutOfBoundsException("Index out of bound.");
        return (Array[index]);
    };

    public int getCount(){
        return (Array.length);
    };
}