package thread.threadpool.executor;

import java.util.ArrayList;
import java.util.List;

public class CustomExecutorService {

    public static void main(String args[]) {
        int counter = 0;
        MyThreadPool threadPool = new MyThreadPool(5);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Task(counter) {
                @Override
                public void run() {
                    System.out.println("Running Task :: " + identifier);
                }
            });
            counter = counter + 1;
        }

    }

}

