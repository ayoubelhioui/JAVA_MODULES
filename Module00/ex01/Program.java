package ex01;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Program{
    public static int readFromUser(){
        int enteredNumber = 0;
        System.out.print("-> ");
        Scanner sc = new Scanner(System.in);
        enteredNumber = sc.nextInt();
        return (enteredNumber);
    }

    public static void isPrimeNumber(int enteredNumber){
        int iterations = 0;
        int sqrtN = (int)Math.sqrt(enteredNumber);
        for (int i = 2; i <= sqrtN; i++) {
            iterations++;
            if (enteredNumber % i == 0) {
                System.out.println("false " + iterations);
                return ;
            }
        }
        System.out.println("true " + (iterations + 1));
    }

    public static void main(String[] args){
        int enteredNumber = 0;
        try{
            enteredNumber = readFromUser();
        }
        catch(InputMismatchException e) {
            System.out.println("Enter a valid number");
        }
        if (enteredNumber <= 1)
        {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        isPrimeNumber(enteredNumber);
    }
}