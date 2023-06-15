package ex00;
class User{
    private int id;
    private String Name;
    private int Balance;

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

}