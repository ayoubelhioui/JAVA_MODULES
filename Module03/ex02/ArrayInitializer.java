package ex02;

import java.util.Scanner;
import java.util.Random;

class ArrayInitializer {
    private int[] array;
    private int arraySize;
    private int threadsCount;
    private static Scanner standardInputScanner;
    private static Random randomNumberGenertor;

    public ArrayInitializer() {
        this.standardInputScanner = new Scanner(System.in);
        randomNumberGenertor = new Random();
    }

    private void readInput() {
        System.out.print("-> ");
        this.arraySize = standardInputScanner.nextInt();
        this.threadsCount = standardInputScanner.nextInt();
        array = new int[arraySize];
    }

    public int[] getArray() {
        return (this.array);
    }

    public int getArraySize() {
        return (this.arraySize);
    }

    public void initialize() {
        this.readInput();
        for (int i = 0; i < arraySize; i++)
            this.array[i] = randomNumberGenertor.nextInt(500);
    }
}