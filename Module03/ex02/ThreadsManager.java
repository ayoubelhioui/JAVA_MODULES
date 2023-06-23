package ex02;

import ex02.Threads;

class ThreadsManager {
    private int threadsCount;
    private int array[];
    private Thread[] threads;
    private int arraySize;
    private int totalSum;


    public ThreadsManager(int threadsCount, int array[], int arraySize)  {
        this.threadsCount = threadsCount;
        this.array = array;
        this.threads = new Thread[threadsCount];
        this.arraySize = arraySize;
        this.totalSum = 0;
    }

    private void joinThreads() throws InterruptedException{
        for (int i = 0; i < threadsCount; i++)
            this.threads[i].join();
    }

    public void startSumming() throws InterruptedException{
        int sectionCount = this.arraySize / threadsCount, startIndex = 0, endIndex = sectionCount - 1;
        for (int i = 0; i < threadsCount - 1; i++) {
            this.threads[i] = new Thread(new Threads(startIndex, endIndex, this.array, i + 1));
            this.threads[i].start();
            startIndex += sectionCount;
            endIndex += sectionCount;
        }
        endIndex += (this.arraySize % threadsCount);
        Threads lastThread = new Threads(startIndex, endIndex, this.array, this.threadsCount);
        this.threads[this.threadsCount - 1] = new Thread(lastThread);
        this.threads[this.threadsCount - 1].start();
        this.joinThreads();
        System.out.println("Sum by threads: " + lastThread.getTotalSum());
    }
}