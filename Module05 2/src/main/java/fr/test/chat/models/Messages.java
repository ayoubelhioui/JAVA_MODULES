package fr.test.chat.models;

import java.util.Date;
public class Messages {
    public long getId() { return id; }

//    public User getAuthor() {
//        return new User();
//    }

    public ChatRoom getRoom() { return new ChatRoom(); }

    public String getText() { return text; }

    public Date getDate() { return date; }

    private long id;
    private User author;
    private long room;
    private String text;
    private Date date;

    private Messages() { }
    public Messages(long id, long author, long room, String text, Date date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }
}