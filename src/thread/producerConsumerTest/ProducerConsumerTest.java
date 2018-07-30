package thread.producerConsumerTest;

import java.util.ArrayList;

public class ProducerConsumerTest {

    public static void main(String args[]) {
        ProducerConsumerTest object = new ProducerConsumerTest();
        Consumer consumer1 = object.new Consumer();
        Consumer consumer2 = object.new Consumer();
        Consumer consumer3 = object.new Consumer();
        consumer1.consumerId = 1;
        consumer2.consumerId = 2;
        consumer3.consumerId = 3;
        Producer producer = object.new Producer();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer.start();

    }

    ArrayList sharedQueue = new ArrayList();

    int maxSize = 100;

    class Producer extends Thread {
        long counter = 0;

        @Override
        public void run() {

            while (true) {
                int size = sharedQueue.size();
                if (size != maxSize) {
                    synchronized (sharedQueue) {
                        int i = 0;
                        while (i < 10 && size < maxSize) {
                            System.out.println("Producer : produced   => " + counter);
                            sharedQueue.add(counter++);
                            i++;
                            size++;
                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {
        int consumerId = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (sharedQueue) {
                    if (sharedQueue.size() != 0) {
                        System.out.println("Consumer : " + consumerId + " consumed   => " + sharedQueue.remove(0));
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}