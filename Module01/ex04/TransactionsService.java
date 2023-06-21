package ex04;

import CustomExceptions.IllegalTransactionException;
import CustomExceptions.TransactionNotFoundException;
import CustomExceptions.UserNotFoundException;
import java.util.UUID;


class TransactionsService{
    public UsersList usersList;

    public void addUser(User user){
        usersList.add(user);
    }

    public int getUserBalance(int id) throws UserNotFoundException{
        return (usersList.getById(id).getBalance());
    }

    public void performTransaction(int senderId, int receipentId, int transferedAmount)
            throws UserNotFoundException, IllegalTransactionException {
        MyEnum transactionType = MyEnum.credit;
        User sender = this.usersList.getById(senderId);
        if (transferedAmount > sender.getBalance())
            throw new IllegalTransactionException("Cannot perform transaction due to user low balance.");
        User receipent = this.usersList.getById(receipentId);
        Transaction transaction = new Transaction(receipent, sender, transactionType, transferedAmount);
        sender.transactionsList.add(transaction);
        transaction.setMyEnum(MyEnum.debit); // overriding the transaction type so that it becomes debit for the receipent.
        receipent.transactionsList.add(transaction);
    }

    public Transaction[] retrievingUserTransactions(int userId) throws UserNotFoundException {
        return (usersList.getById(userId).transactionsList.toArray());
    }

    public void removeTrancsationById(int userId, UUID transactionId)
            throws UserNotFoundException, TransactionNotFoundException {
        User user = usersList.getById(userId);
        user.transactionsList.removeById(transactionId);
    }

//    public Transaction[] retreiveInvalidTrancsations() { still confused.
//
//    }
}