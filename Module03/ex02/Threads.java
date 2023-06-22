package ex02;

class Threads implements Runnable{
    private int startIndex;
    private int endIndex;
    private int array[];
    private int arraySum;
    private int threadIndex;
    private static int totalSum = 0;

    public Threads(int startIndex, int endIndex, int array[], int threadIndex) {
        this.arraySum = 0;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
        this.threadIndex = threadIndex;
    }

    public void run() {
        int start = this.startIndex, end = this.endIndex;
        while (start <= end)
            arraySum += array[start++];
        totalSum += arraySum;
        System.out.println("Thread " + threadIndex + " : from " + this.startIndex
                + " to " + this.endIndex + " sum is " + arraySum);
    }

    public int getTotalSum() {
        return (totalSum);
    }
}