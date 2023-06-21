package ex01;
import ex01.Threads;
class Program {
    public static void main(String[] args) {
        try{
            Threads threads = new Threads();
            threads.startThreads();
            threads.joinThreads();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}