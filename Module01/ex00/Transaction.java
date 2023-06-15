package ex00;

import java.util.UUID;

class Transaction{
    private UUID id;
    private User Receipent;
    private User Sender;
    private MyEnum myEnum;
    private int transferAmount;


    public int getTransferAmount() {
        return (transferAmount);
    }
    public void setTransferAmount(int transferAmount) {
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

    private enum MyEnum{
        debit,
        crecdit
    }
}