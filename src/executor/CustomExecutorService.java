package executor;

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

abstract class Task {
    int identifier;

    Task(int identifier) {
        this.identifier = identifier;
    }

    public abstract void run();
}


class MyThreadPool {

    int nPoolThreads;
    PoolThread[] threads ;
    List<Task> tasks = new ArrayList<Task>();
    boolean shutdown = false;

    public void submit(Task task) {
        tasks.add(task);
    }

    MyThreadPool(int nPoolThreads) {
        this.nPoolThreads = nPoolThreads;
        threads = new PoolThread[nPoolThreads];
        for (int i = 0; i < nPoolThreads; i++) {
            threads[i] = new PoolThread();
            threads[i].start();
        }
    }

    class PoolThread extends Thread {

        @Override
        public void run() {
            while (!shutdown) {

                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tasks.remove(0).run();
                }
            }
        }
    }
}