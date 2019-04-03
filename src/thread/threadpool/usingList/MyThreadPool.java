package thread.threadpool.usingList;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {

    List<Runnable> tasks;
    List<WorkerThread> workers;
    private boolean isShutdown;
    private int size;

    MyThreadPool(int size) {
        this.size = size;
        this.isShutdown = false;
        for (int i = 0; i < size; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.start();
        }
        tasks = new ArrayList<>();
    }

    public void add(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }

    public void shutdown() {
        this.isShutdown = true;
        for(WorkerThread worker : workers){
            worker.stop();
        }
    }


    class WorkerThread extends Thread {

        @Override
        public void run() {

            while (!isShutdown) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread : " + this.getName());
                    tasks.remove(0).run();
                }
            }

        }

    }


}
