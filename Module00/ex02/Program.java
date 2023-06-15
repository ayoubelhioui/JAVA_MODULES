package ex02;

import java.util.Scanner;

class Program{
    private static int sumResult = 0;

    public static int readInputAndCount(){
        int enteredNumber = 0, primeNumbersCount = 0;
        sumResult = 0;
        while (enteredNumber != 42)
        {
            System.out.print("-> ");
            Scanner sc = new Scanner(System.in);
            enteredNumber = sc.nextInt();
            calculateSum(enteredNumber);
            if (isPrimeNumber(sumResult))
                primeNumbersCount++;
        }
        return (primeNumbersCount);
    }

    public static boolean isPrimeNumber(int enteredNumber){
        int iterations = 0;
        int sqrtN = (int)Math.sqrt(enteredNumber);
        for (int i = 2; i <= sqrtN; i++) {
            iterations++;
            if (enteredNumber % i == 0) {
                return (false);
            }
        }
        return (true);
    }

    public static void calculateSum(int number){
        if (number == 0)
            return ;
        sumResult += number % 10;
        calculateSum(number / 10);
    }

    public static void main(String[] args){
        System.out.println("Count of coffee-request : " + readInputAndCount());
    }
}