package fr.test.numbers;

import fr.test.exceptions.IllegalNumberException;

import java.util.Scanner;
public class NumberWorker {

    private int result = 0;
    private void calculate(int number) {
        if (number == 0)
            return ;
        result += number % 10;
        calculate(number / 10);
    }
    public int calculateSum(int number) {
        calculate(number);
        return (result);
    }

    private int readFromUser() {
        int enteredNumber = 0;
        System.out.print("-> ");
        Scanner sc = new Scanner(System.in);
        enteredNumber = sc.nextInt();
        return (enteredNumber);
    }

    public boolean isPrimeNumber(int enteredNumber) throws IllegalNumberException{
        if (enteredNumber <= 1)
            throw new IllegalNumberException("Invalid input");
        int sqrtN = (int)Math.sqrt(enteredNumber);
        for (int i = 2; i <= sqrtN; i++) {
            if (enteredNumber % i == 0) {
                return (false);
            }
        }
        return (true);
    }
}
