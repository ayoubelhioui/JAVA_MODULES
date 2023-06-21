package ex03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

class TransactionNotFoundException extends Exception{
    TransactionNotFoundException(String message){
        super(message);
    }
}

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