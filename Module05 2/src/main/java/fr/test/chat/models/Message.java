package fr.test.chat.models;

import java.time.LocalDateTime;
import java.util.Date;
public class Message {
    public long getId() { return id; }

    public User getAuthor() { return (this.author); }

    public Room getRoom() { return this.room; }

    public String getText() { return text; }

    public LocalDateTime getDate() { return date; }

    private Long id;
    private User author;
    private Room room;
    private String text;
    private LocalDateTime date;

    private Message() { }
    public Message(Long id, User author, Room room, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }
}