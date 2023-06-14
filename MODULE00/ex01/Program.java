package ex01;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Program{
    public static void readFromUser(){

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("-> ");
        int number = 0;
        try{
            number = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Enter a valid number");
        }
        System.out.println("the number is " + number);
    }
}