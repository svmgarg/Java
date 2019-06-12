package hackerrank.test;

import temp.Test;

public class Test2 {

    public static void main(String args[]) {

        Object mutex = new Object();
        Thread odd = new Thread(new OddThread(mutex));
        Thread even = new Thread(new EvenThread(mutex));

        odd.start();
        even.start();
    }
    static  boolean isOdd = true;

}

class OddThread implements Runnable {
    Object mutex;
    OddThread(Object mutex){
        this.mutex= mutex;
    }
    public void run() {

        while (true) {
            synchronized (mutex) {
                if (! Test2.isOdd) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    System.out.println(1);
                    Test2.isOdd =false;
                    mutex.notifyAll();
                }
            }


        }


    }
}


class EvenThread implements Runnable {
    Object mutex;
    EvenThread(Object mutex){
        this.mutex= mutex;
    }

    public void run() {
        while (true) {
            synchronized (mutex) {
                if (Test2.isOdd) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                    }
                } else {

                    System.out.println(2);
                    Test2.isOdd =true;
                    mutex.notifyAll();
                }
            }
        }


    }

}