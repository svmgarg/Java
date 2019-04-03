package thread.threadpool.usingQueue;

public class Test {

    public static void main(String args[]) {

        MyThreadPoolUsingQueue threadPool = new MyThreadPoolUsingQueue(4);
        for (int i = 0; i <= 100; i++) {
            final int ii = i;

            threadPool.add(() -> {
                for (int k = 0; k < 10; k++) {
                    System.out.println("Task : " + ii);
                }
            });

        }

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();

    }
}
