package ex04;

class Program{
    public static void main(String[] args){
        User Mike = new User("Mike", 400);
        User John = new User("John", 500);
        MyEnum myEnum = MyEnum.debit;
        Transaction firstTr = new Transaction(Mike, John, myEnum, 200);
        User Imad = new User("Imad", 5000);
        User Ilyass = new User("Ilyass", 2500);
        User Brahim = new User("Brahim", 5100);
        User chichmana = new User("Chichmana", 19999);
    }
}