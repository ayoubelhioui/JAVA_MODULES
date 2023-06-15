package ex03;

import java.util.Scanner;

class Program{
    public static int readInputAndCount(){
        int enteredNumber = 0;
        while (enteredNumber != 42)
        {
            System.out.print("-> ");
            Scanner sc = new Scanner(System.in);
            enteredNumber = sc.nextInt();
        }
        return (0);
    }
}