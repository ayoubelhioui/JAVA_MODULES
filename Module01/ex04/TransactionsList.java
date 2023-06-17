package ex03;

import java.util.UUID;

interface TransactionsList{
    void add(Transaction transaction);
    void removeById(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
}