package ex03;

import java.util.Scanner;

class Program{
    private static int weeksIndex = 1;
    final private static Scanner standardInputScanner = new Scanner(System.in);
    public static void readWeek(){
        System.out.print("-> ");
        String enteredWeek = standardInputScanner.next();
        System.out.println(enteredWeek + " --- Week " + weeksIndex);
        if (!enteredWeek.equals("Week " + weeksIndex))
        {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        weeksIndex++;
    }
    public static int readInputAndCount(){
        int enteredNumber = 0, weeksCount = 1, testsCount = 1;
        while (enteredNumber != 42 && weeksCount < 18)
        {
            readWeek();
//            System.out.print("-> ");
            weeksCount++;
        }
        return (0);
    }

    public static void main(String[] args){
        readInputAndCount();
    }
}