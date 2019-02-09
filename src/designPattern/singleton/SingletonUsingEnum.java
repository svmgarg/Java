package designPattern.singleton;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingletonUsingEnum {

    public static void main(String[] agrs) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable task1 = () -> {
            System.out.println(new Date().getTime());
            System.out.println(Singleton.INSTANCE.getLogger().getInstanceIdentifier());
        };
        Runnable task2 = () -> {
            System.out.println(new Date().getTime());
            System.out.println(Singleton.INSTANCE.getLogger().getInstanceIdentifier());
        };
        Runnable task3 = () -> {
            System.out.println(new Date().getTime());
            System.out.println(Singleton.INSTANCE.getLogger().getInstanceIdentifier());
        };

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        try {
            executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


enum Singleton {
    INSTANCE;


    private Logger logger;

    private Singleton() {
        logger = new Logger();
        logger.setInstanceIdentifier( Math.random());
    }

    public Logger getLogger() {
        return this.logger;
    }
}


class Logger {

    private double instanceIdentifier;

    public double getInstanceIdentifier() {
        return instanceIdentifier;
    }

    public void setInstanceIdentifier(double instanceIdentifier) {
        this.instanceIdentifier = instanceIdentifier;
    }
}