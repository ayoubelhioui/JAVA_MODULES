package fr.test.chat.models;

import java.util.List;

public class User{
    private int id;
    private String login;
    private List<ChatRoom> createdRooms;
    private List<ChatRoom> roomsUserBelongsTo;
}