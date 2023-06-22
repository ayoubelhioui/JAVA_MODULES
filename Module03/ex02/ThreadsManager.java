package ex02;

import ex02.Threads;

class ThreadsManager{
    private int threadsCount;
    private int array[];
    private Thread[] threads;
    private int arraySize;


    public ThreadsManager(int threadsCount, int array[], int arraySize)  {
        this.threadsCount = threadsCount;
        this.array = array;
        this.threads = new Thread[threadsCount];
        this.arraySize = arraySize;
    }

    public void startSumming() {
        int sectionCount = this.arraySize / threadsCount, startIndex = 0, endIndex = sectionCount - 1;
        for (int i = 0; i < threadsCount; i++){
            threads[i] = new Thread(new Threads(startIndex, endIndex, this.array, i + 1));
            threads[i].start();
            if (i == threadsCount - 1)
                endIndex += (this.arraySize % threadsCount);
            startIndex += sectionCount;
            endIndex += sectionCount;
        }

    }
}