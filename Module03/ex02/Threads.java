package ex02;

class Threads implements Runnable{
    private int startIndex;
    private int endIndex;
    private int array[];
    private int arraySum;
    private int threadIndex;

    public Threads (int startIndex, int endIndex, int array[], int threadIndex) {
        this.arraySum = 0;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
        this.threadIndex = threadIndex;
    }

    public void run() {
        int start = startIndex, end = endIndex;
        while (start <= end)
            arraySum += array[start++];
        System.out.println("Thread " + threadIndex + " : from " + start
                + " to " + end + " sum is " + arraySum);
    }
}