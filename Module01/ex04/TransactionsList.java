package ex04;

import java.util.UUID;
import CustomExceptions.TransactionNotFoundException;

interface TransactionsList{
    void add(Transaction transaction);
    void removeById(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
}