package ex04;

import java.util.Scanner;

class Program{
    private static int userInputLength = 0;
    private static String userInput;
    private static char[] toChar;
    final private static Scanner standardInputScanner = new Scanner(System.in);
    public static void readUserInput(){
        System.out.print("--> ");
        userInput = standardInputScanner.next();
    }

    public static void countCharactersOccurence() {
        int[] occurancyCounter = new int[65535];
        for (int i = 0; i < userInputLength; i++)
            occurancyCounter[toChar[i]]++;
        for (int i = 0; i < 65535; i++)
            if (occurancyCounter[i] != 0)
                System.out.println("the count of : " + (char)i + " is :" + occurancyCounter[i]);
    }

    public static void printTheGraph(){

    }

    public static void main(String[] args){
        readUserInput();
        userInputLength = userInput.length();
        toChar = new char[userInputLength];
        toChar = userInput.toCharArray();
        countCharactersOccurence();
        printTheGraph();
    }
}