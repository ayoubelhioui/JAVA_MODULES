package ex03;

import java.util.Scanner;

class Program{
    private static int weeksIndex = 1;
    final private static Scanner standardInputScanner = new Scanner(System.in);
    public static void readAndMatchWeek(){
        System.out.print("-> ");
        standardInputScanner.next();
        int enteredWeek = standardInputScanner.nextInt();
        if (enteredWeek != weeksIndex)
        {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        weeksIndex++;
    }

    public static void readTestsGrade(){

    }

    public static int readUserInput(){
        int enteredNumber = 0, weeksCount = 1, testsCount = 1;
        while (enteredNumber != 42 && weeksCount < 18)
        {
            readAndMatchWeek();
            readTestsGrade();
            weeksCount++;
        }
        return (0);
    }

    public static void main(String[] args){
        readUserInput();
    }
}