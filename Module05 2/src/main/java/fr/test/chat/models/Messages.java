package fr.test.chat.models;

import java.util.Date;
public class Messages {
    public int getId() { return id; }

    public User getAuthor() { return author; }

    public ChatRoom getRoom() { return room; }

    public String getText() { return text; }

    public Date getDate() { return date; }

    private int id;
    private User author;
    private ChatRoom room;
    private String text;
    private Date date;

    private Messages() { }
    private Messages(int id, User author, ChatRoom room, String text, Date date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }
}