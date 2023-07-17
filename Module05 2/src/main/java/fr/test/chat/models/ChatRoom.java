package fr.test.chat.models;

import java.util.List;

public class ChatRoom {
    private int id;
    private String name;
    private User owner;
    private List<Messages> messages;
}