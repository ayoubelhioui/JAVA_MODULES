package ex04;

import CustomExceptions.TransactionNotFoundException;
import CustomExceptions.UserNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

class TransactionLinkedList implements TransactionsList{

    private static LinkedList<Transaction> transactionsList;

    TransactionLinkedList(){
        transactionsList = new LinkedList<Transaction>();
    }

    public void add (Transaction transaction){
        transactionsList.add(transaction);
    }

    public void removeById(UUID id) throws TransactionNotFoundException{
        Iterator<Transaction> it = transactionsList.iterator();
        while (it.hasNext()) {
            Transaction tr = it.next();
            if (tr.getId() == id)
            {
                System.out.println("Transaction deleted succussfully");
                transactionsList.remove(tr);
                return ;
            }
        }
        throw new TransactionNotFoundException("there's no transaction with this id.");
    }

    public Transaction[] toArray(){
        return (Transaction[]) this.transactionsList.toArray();
    }

}