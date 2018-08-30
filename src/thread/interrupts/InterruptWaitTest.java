package thread.interrupts;

public class InterruptWaitTest {
    public static void main(String args[]) {

        InterruptWaitTest object = new InterruptWaitTest();
        SharedResource resource = object.new SharedResource();

        MyFirstThread myFirstThread = object.new MyFirstThread();
        myFirstThread.parentThread = Thread.currentThread();
        myFirstThread.start();

        /**
         * Here We have created a thread and our main thread is waiting on resource object
         * Before notification on resource, main thread will be interrupted by "myFirstThread"
         * As soon as main thread will get interrupt it will further continue the execution.
         */

        synchronized (resource) {
            try {
                resource.wait();
            } catch (InterruptedException e) {
                System.out.println("################### Main Thread Interrupted ");
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread : " + i);
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


    class SharedResource {
    }
}