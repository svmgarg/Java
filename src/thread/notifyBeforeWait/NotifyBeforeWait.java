package thread.notifyBeforeWait;

public class NotifyBeforeWait {

    public static void main(String args[]) {

        NotifyBeforeWait object = new NotifyBeforeWait();
        SharedResource resource = object.new SharedResource();

        synchronized (resource) {
            try {
                resource.notify();
                System.out.println("Notifying the resource");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Starting My thread");
        MyThread thread = object.new MyThread();
        thread.resource =  resource;
        thread.start();
    }

    class MyThread extends Thread {
        SharedResource resource;

        public  void run(){

            synchronized (resource)

            {
                System.out.println("MyThread  getting lock on wait");
                try {
                    System.out.println("MyThread  in wait");
                    resource.wait();
                    System.out.println("Out of wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    class SharedResource {

    }

}
