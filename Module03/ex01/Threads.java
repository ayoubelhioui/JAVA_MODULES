package ex01;

import java.util.Scanner;

class Threads{
    private static Scanner standardInputScanner;
    private Thread eggThread;
    private Thread henThread;
    private int printingCount;
    private boolean sharedResource;
    private Object monitor;

    public Threads() {
        this.monitor = new Object();
        standardInputScanner = new Scanner(System.in);
        this.printingCount = 0;
        this.sharedResource = false;
    }

    private void readInput() {
        System.out.print("-> ");
        this.printingCount = standardInputScanner.nextInt();
    }

    private void printThreadMessage(String threadMessage) throws InterruptedException {
        System.out.println(threadMessage);
    }

    public void joinThreads() throws InterruptedException {
        this.eggThread.join();
        this.henThread.join();
    }

    private void start() throws InterruptedException {
        this.eggThread = new Thread(() -> {
            for (int i = 0; i < printingCount / 2; i++)
            {
                synchronized (monitor) {
                    try {
                        if (this.sharedResource == false)
                            monitor.wait();
                        printThreadMessage("Hen");
                        this.sharedResource = false;
                        monitor.notify();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        this.henThread = new Thread(() -> {
            for (int i = 0; i < printingCount / 2; i++)
            {
                synchronized (monitor){
                    try{
                        if (this.sharedResource == true)
                            monitor.wait();
                        printThreadMessage("Egg");
                        this.sharedResource = true;
                        monitor.notify();
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    monitor.notify();
                }
            }

        });
        this.eggThread.start();
        this.henThread.start();
    }

    public void startThreads() throws InterruptedException {
        this.readInput();
        this.start();
    }
}