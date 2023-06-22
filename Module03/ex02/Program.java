package ex02;

import ex02.ArrayInitializer;
import ex02.ThreadsManager;
import java.lang.reflect.Array;

class Program {
    public static void main(String[] args) {
        try {
            ArrayInitializer arrayInitializer = new ArrayInitializer();
            arrayInitializer.initialize();
            ThreadsManager threadsManager = new ThreadsManager(arrayInitializer.getThreadsCount(),
                    arrayInitializer.getArray(), arrayInitializer.getArraySize());
            threadsManager.startSumming();
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}