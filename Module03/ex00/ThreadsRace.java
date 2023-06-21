package ex00;

import java.util.Scanner;

class ThreadsRace {
    private Thread eggThread;
    private Thread henThread;
    private static Scanner standardInputScanner;
    private int printingCount;
    private String sharedResource;

    public int getPrintingCount() {
        return printingCount;
    }

    public ThreadsRace() {
        standardInputScanner = new Scanner(System.in);
        this.printingCount = 0;
    }

    private void readInput() {
        System.out.print("-> ");
        this.printingCount = standardInputScanner.nextInt();
    }

    private void printWinner(String winnerMessage) throws InterruptedException {
        System.out.println("the winner is : " + winnerMessage);
    }

    private void start() throws InterruptedException {
        this.eggThread = new Thread(() -> {
            for (int i = 0; i < this.printingCount; i++)
                System.out.println("Egg");
            this.sharedResource = "Egg";
        });
        this.henThread = new Thread(() -> {
            for (int i = 0; i < this.printingCount; i++)
                System.out.println("Hen");
            this.sharedResource = "Hen";
        });
        this.eggThread.start();
        this.henThread.start();
    }

    public void mainThreadPrinting() {
        for(int i = 0; i < this.printingCount; i++)
            System.out.println("Human");
    }

    public void joinThreads() throws InterruptedException {
        this.eggThread.join();
        this.henThread.join();
        this.printWinner(this.sharedResource);
    }

    public void startThreads() throws InterruptedException {
        this.readInput();
        this.start();
    }
}