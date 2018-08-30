package thread.interrupts;

public class InterruptJoinTest {
    public static void main(String args[]) {

        InterruptJoinTest object = new InterruptJoinTest();

        MyFirstThread first = object.new MyFirstThread();
        Thread firstThread = new Thread(first);
        firstThread.setName("First Thread");
        firstThread.start();

        MySecondThread second = object.new MySecondThread();
        second.setParentThread(Thread.currentThread());
        Thread secondThread = new Thread(second);
        secondThread.setName("Second Thread");
        secondThread.start();

        /**
         * Here We have created two threads and our main thread is waiting for first thread to complete
         * meanwhile secord thread is interrupting the main thread.
         * As soon as main thread will get interrupt it will further continue the execution.
         */
        try {
            firstThread.join(10000);
        } catch (InterruptedException e) {
            System.out.println(" #######################    Main Thread interrupted ");
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }


    class MyFirstThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class MySecondThread implements Runnable {

        Thread parentThread = null;

        public Thread getParentThread() {
            return parentThread;
        }

        public void setParentThread(Thread parentThread) {
            this.parentThread = parentThread;
        }

        @Override
        public void run() {
            try {
                System.out.println("Main Thread will be interrupted after 5 seconds ...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (parentThread) {
                parentThread.interrupt();
                System.out.println("In Second Thread , Main Thread interrupted ");
            }

        }
    }
}




