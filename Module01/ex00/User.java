package ex00;


class User{
    private int id;
    private String Name;
    private int Balance;

    private User() {}
    User(int id, String Name, int Balance){
        this.id = id;
        this.Name = Name;
        if (Balance > 0)
            this.Balance = Balance;
    }
    int getId() {
        return (this.id);
    }
    void setId(int id){
        this.id = id;
    }

    String getName() {
        return (this.Name);
    }
    void setName(String Name){
        this.Name = Name;
    }

    int getBalance(){
        return (this.Balance);
    }
    void setBalance(int Balance){
        if (Balance > 0)
            this.Balance = Balance;
    }

    public void printUserContent(){
        System.out.println("the user id is : " + this.id + " and " +
        "username is : " + this.Name + " and the Balance is" +
        this.Balance);
    }
}