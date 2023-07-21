package fr.test.chat.models;

import java.util.List;

public class User {

    private long id;
    private String login;
    private String password;
    private List<Message> createdRooms;
    private List<Message> roomsUserBelongsTo;

    public User() {}
    public User(long id, String login, String password, List<Message> createdRooms, List<Message> roomsUserBelongsTo) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.roomsUserBelongsTo = roomsUserBelongsTo;
    }

    public void printUserInfo () {
        System.out.println("    User = { id = " + this.id + ", name = \"" + this.login +
                "\", owner =\"" + this.password + "\", createdRoom = \"null\", rooms = \"null\" }");
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() { return id; }

    public String getLogin() { return login; }
}