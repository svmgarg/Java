package thread.interrupts;

public class InterruptSleepTest {
    public static void main(String args[]) {

        InterruptSleepTest object = new InterruptSleepTest();

        MyFirstThread myFirstThread = object.new MyFirstThread();
        myFirstThread.parentThread = Thread.currentThread();
        myFirstThread.start();

        /**
         * Here We have created a thread who will be interrupting the main thread when main thread will sleep
         * As soon as main thread will get interrupt it will further continue the execution.
         */

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread : "+ i);
        }


        }

    class MyFirstThread extends Thread {

        Thread parentThread;

        @Override
        public void run() {
            int n = 5;
            for (int i = 0; i < n; i++) {
                try {
                    System.out.println("Main Thread will be Interrupted after  " + (n - i) + "  sec ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Interrupting Main Thread ");
            parentThread.interrupt();

        }
    }

}
