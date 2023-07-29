package fr.test.models;

public class User {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    private String name;
    private String password;
    private boolean isAuthenticate;

    public User() {}

    public User(long id, String name, String password, boolean isAuthenticate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isAuthenticate = isAuthenticate;
    }

}
