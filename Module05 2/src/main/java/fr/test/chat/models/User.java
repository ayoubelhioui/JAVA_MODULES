package fr.test.chat.models;

import java.util.List;

public class User{
    public long getId() { return id; }

    public String getLogin() { return login; }

//    public List<ChatRoom> getCreatedRooms() { return createdRooms; }
//
//    public List<ChatRoom> getRoomsUserBelongsTo() { return roomsUserBelongsTo; }
    public User() {}
    private long id;
    private String login;
    private List<Long> createdRooms;
    private List<Long> roomsUserBelongsTo;
}