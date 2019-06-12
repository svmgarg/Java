package dummy;

public class Practice1 {

    public static void main(String args[]){

        Practice1 practice = new Practice1();

        MyThread oneThread = practice.new MyThread("1",1);
        MyThread zeroThread = practice.new MyThread("0",0);
        MyThread twoThread = practice.new MyThread("2",2);

        oneThread.start();
        zeroThread.start();
        twoThread.start();
    }

    Object lock = new Object();
    Integer currentCount =0;
    class MyThread extends Thread{

        String name;
        Integer threadType =0;

        MyThread(String name , int threadType){
            this.name = name;
            this.threadType = threadType;
        }
        public void run(){
            this.print();
        }

        public void print(){

            while(currentCount<100){
                synchronized (lock){
                    while (currentCount % 3 != threadType ){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(currentCount<100) {
                        System.out.println(name + "\t" + currentCount++);
                    }
                    lock.notifyAll();
                }
            }


        }
    }




}
