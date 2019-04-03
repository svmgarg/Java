package thread.threadpool.executor;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {

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
                    //tasks.remove(0).run();
                }
            }
        }
    }
}