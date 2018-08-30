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
                    System.out.println(this.getName() + "  got lock");
                    if (counter % 2 != remainder) {
                        try {
                            System.out.println("Remainder didn't match so waiting on lock");
                            lock.wait();
                            System.out.println("Notification recieved  : " + this.getName());
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
/**
 * Here we have created a lock which will enable threads to run one by one
 * First we are checking for counter value < 10 if it is less than 10 then we will allow thread to print counter value
 * now thread need to acquire the lock in order to print the counter value
 * Every thread has a unique identifier say remainder 1 => odd thread ans remainder 0 => even thread
 *
 * After getting the lock, If it's not current thread turn (counter%2 != remainder  => validate whether is thread turn or not)  then it will wait on lock
 * After getting lock if it's current thread run then it will print the counter value and notify the other thread
 */