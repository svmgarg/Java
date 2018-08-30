package thread.lock.classLevelLock;

/**
 * Below Example shows that
 * when a thread acquired the class-level lock for execution of "static synchronized" method.
 * Then no other thread is allowed to execute any other "static synchronised method"
 */
public class ClassLockTester {

    public static void main(String args[]) {
        ClassLockTester tester = new ClassLockTester();

        MyRunnable r1 = tester.new MyRunnable(" R1");
        MyRunnable r2 = tester.new MyRunnable(" R2");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        MyThread t3 = tester.new MyThread();

        /**
         * Staring 3 threads which are consuming the shared resource service
         */
        t1.start();
        t2.start();
        t3.start();
    }


    class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            SharedResource.runnableExecution(this.name);
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            SharedResource.threadExecution(this.getName());
        }
    }

}

/**
 * Shared Resource
 */
class SharedResource {

    static long counter = 0;

    synchronized static void runnableExecution(String threadName) {
        System.out.println("Entering Runnable -> " + threadName + " and  Counter is -> " + counter);
        for (long i = 0; i < 10000; i++) {
            System.out.println("Executing Runnable-> " + threadName + " and  Counter is -> " + ++counter);
            Thread.currentThread().yield();
        }
        System.out.println("**************************Exiting Runnable  " + threadName + "********************************");
    }

    synchronized static void threadExecution(String threadName) {
        System.out.println("Entering thread -> " + threadName + " and  Counter is -> " + counter);
        for (long i = 0; i < 10000; i++) {
            System.out.println("Executing thread -> " + threadName + " and  Counter is -> " + ++counter);
            Thread.currentThread().yield();
        }
        System.out.println("******************************** Exiting thread  " + threadName + "********************************");
    }
}
