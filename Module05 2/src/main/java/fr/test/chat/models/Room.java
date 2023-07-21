package fr.test.chat.models;

import java.util.List;



public class Room {


    private long id;
    private String name;
    private User owner;
    private List<Message> Message;

    public Room() { }
    public Room(long id, String name, User owner, List<Message> Message) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.Message = Message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessage() {
        return Message;
    }

    public void setMessage(List<Message> Message) {
        this.Message = Message;
    }

    public void printRoomInfo () {
        System.out.println("    room = { id = " + this.id + ", name = \"" + this.name +
                "\", creator = \"null\", Message = \"null\" }");
    }
}