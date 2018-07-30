package thread.oddEvenThread;

public class OddEvenThreadTester {

    public static void main(String args[]) {
        OddEvenThreadTester object = new OddEvenThreadTester();
        MyThread t = object.new MyThread();
        t.remainder = 0;
        MyThread t1 = object.new MyThread();
        t1.remainder = 1;
        t.start();
        t1.start();

    }


    int counter = 0;
    Object lock = new Object();

    class MyThread extends Thread {

        int remainder = -1;

        @Override
        public void run() {
            printValue();
        }

        public void printValue() {
            while (counter < 10) {
                synchronized (lock) {
                    while (counter % 2 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(this.getName() + "  :  " + counter++);
                    lock.notifyAll();
                }

            }
        }
    }

}

