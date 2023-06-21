package ex00;
import ex00.ThreadsRace;

import java.util.Scanner;

class Program {
    public static void main(String[] args) throws InterruptedException {
        try {
                ThreadsRace race = new ThreadsRace();
                race.startThreads();
                race.joinThreads();
                race.mainThreadPrinting();
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}