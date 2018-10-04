package thread.volatileTest;

import java.util.Scanner;

/**
 * Volatile keyword guarantees visibility of changes to variables across threads.
 * variable value will never be cached thread-locally: all reads, and writes will go straight to "main memory".
 *
 * If variable "running" is not declared as volatile  in that case the threads might cache the variable in their local memeory
 * and might not terminate even after its value changed to false.
 *
 */

public class VolatileTest {

    private volatile boolean running = true;

    public static void main(String args[]) {

        VolatileTest test = new VolatileTest();
        Processor process1 = test.new Processor("Thread 1");
        process1.start();

        Processor process2 = test.new Processor("Thread 2");
        process2.start();

        // Wait for the enter key
        new Scanner(System.in).nextLine();
        test.running = false;
        System.out.println("Value updated");

    }


    class Processor extends Thread {

        String name;

        public Processor(String name) {
            this.name = name;
        }

        public void run() {
            while (running) {
                System.out.println("Running : " + this.name);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
