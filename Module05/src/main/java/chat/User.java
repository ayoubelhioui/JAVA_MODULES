package src.main.java.chat;

import java.util.List;

public class User{
    private int id;
    private String login;
    private List<ChatRoom> createdRooms;
    private List<ChatRoom> roomsUserBelongsTo;
}