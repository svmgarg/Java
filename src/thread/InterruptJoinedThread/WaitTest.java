package thread;

public class WaitTest {
    public static void main(String args[]) {

        MyFirstThread first = new MyFirstThread();
        Thread firstThread = new Thread(first);
        firstThread.setName("First Thread");
        firstThread.start();

        MySecondThread second = new MySecondThread();
        second.setParentThread(Thread.currentThread());

        Thread secondThread = new Thread(second);
        secondThread.setName("Second Thread");
        secondThread.start();

        try {
            firstThread.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
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
            System.out.println(Thread.currentThread().getName() + " => Notifying Main Thread...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parentThread.notify();
    }
}
