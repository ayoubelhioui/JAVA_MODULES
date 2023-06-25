package main.src.java.chat;

import main.src.java.chat.User;
import main.src.java.chat.Messages;
import java.util.List;

class ChatRoom {
    private int id;
    private String name;
    private User owner;
    private List<Messages> messages;
}