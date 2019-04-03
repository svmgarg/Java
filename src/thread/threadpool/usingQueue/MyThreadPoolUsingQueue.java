package thread.threadpool.usingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolUsingQueue {

    LinkedBlockingQueue<Runnable> tasks;
    List<WorkerThread> workers;
    private boolean isShutdown;
    private int size;

    MyThreadPoolUsingQueue(int size) {
        this.size = size;
        this.isShutdown = false;
        workers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.start();
            workers.add(workerThread);
        }
        tasks = new LinkedBlockingQueue<Runnable>();
    }

    public void add(Runnable runnable) {
        tasks.add(runnable);
    }

    public void shutdown() {
        this.isShutdown = true;
        for (WorkerThread worker : workers) {
            worker.interrupt();
        }
    }


    class WorkerThread extends Thread {

        @Override
        public void run() {

            while (!isShutdown) {

                try {
                    System.out.println("Thread : " + this.getName());
                    tasks.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}