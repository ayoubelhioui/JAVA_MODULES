package ex01;

import java.util.Scanner;

class Threads{
    private Thread eggThread;
    private Thread henThread;
    private int sharedResource;
    private static Scanner standardInputScanner;
    private int printingCount;

    public Threads() {
        standardInputScanner = new Scanner(System.in);
        this.printingCount = 0;
        this.sharedResource = 0; // 0 stands for EGG thread
    }

    private void readInput() {
        System.out.print("-> ");
        this.printingCount = standardInputScanner.nextInt();
    }

    private void start() throws InterruptedException {
        this.eggThread = new Thread(() -> {

        });
        this.henThread = new Thread(() -> {

        });
        this.eggThread.start();
        this.henThread.start();
    }

    public void startThreads() throws InterruptedException {
        this.readInput();
        this.start();
    }
}