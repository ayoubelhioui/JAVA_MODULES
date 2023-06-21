package ex00;



class Program{
    public static void main(String[] args){
        User John = new User(3, "John", 4340);
        User Mike = new User(1, "Mike", 2040);
        Transaction transaction = new Transaction(Mike, John, MyEnum.debit, 4000);
        transaction.printTransactionInfo();
    }
}