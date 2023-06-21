package ex00;

import java.util.UUID;


enum MyEnum{
    debit,
    credit
}

class Transaction{
    private UUID id;
    private User Receipent;
    private User Sender;
    private MyEnum myEnum;
    private int transferAmount;

    private Transaction() {}
    Transaction(User Receipent, User Sender, MyEnum method, int transferAmount){
        if (Sender.getBalance() < transferAmount)
            System.out.println(Sender.getName() + " hasn't enough to send !");
        else {
            this.id = UUID.randomUUID();
            this.Receipent = Receipent;
            this.Sender = Sender;
            this.myEnum = method;
            this.transferAmount = transferAmount;
        }
    }

    public int getTransferAmount() {
        return (transferAmount);
    }
    public void setTransferAmount(int transferAmount) {
        if (transferAmount > 0)
            this.transferAmount = transferAmount;
    }
    public UUID getId() {
        return (id);
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public User getReceipent() {
        return (Receipent);
    }
    public void setReceipent(User receipent) {
        this.Receipent = receipent;
    }


    public void printTransactionInfo(){
        System.out.println(this.Sender.getName() + " has send to " + this.Receipent.getName() + " "
        + this.transferAmount);
    }
}