package ex01;

class Program{
    public static void main(String[] args){
        User Mike = new User("Mike", 400);
        User John = new User("John", 500);
        System.out.println(Mike.getId());
        System.out.println(John.getId());
    }
}