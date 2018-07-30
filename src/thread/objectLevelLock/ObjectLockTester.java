package thread.objectLevelLock;

public class ObjectLockTester {

    public static void main(String args[]) {

        ObjectLockTester tester = new ObjectLockTester();

        PrettyPrinter printer = tester.new PrettyPrinter();

        MyRunnable r1 = tester.new MyRunnable(" R1", printer);
        MyRunnable r2 = tester.new MyRunnable(" R2", printer);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        MyThread t3 = tester.new MyThread(printer);

        t1.start();
        t2.start();
        t3.start();
    }

    class PrettyPrinter {
        public synchronized void runnablePrint(String threadName) {

            for (int i = 0; i < 100; i++) {
                System.out.println("Runnable => " + threadName + "  , Counter => " + i);
            }

        }

        public synchronized void threadPrint(String threadName) {

            for (int i = 0; i < 100; i++) {
                System.out.println("Thread => " + threadName + "  , Counter => " + i);
            }

        }
    }

    class MyRunnable implements Runnable {

        private String name;
        private PrettyPrinter printer;

        public MyRunnable(String name, PrettyPrinter printer) {
            this.name = name;
            this.printer = printer;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            this.printer.runnablePrint(this.name);
        }
    }

    class MyThread extends Thread {

        private PrettyPrinter printer;

        public MyThread(PrettyPrinter printer) {
            this.printer = printer;
        }


        @Override
        public void run() {

            this.printer.threadPrint(Thread.currentThread().getName());
        }
    }

}