package designPattern.behaviour.strategyPattern.fix.algo;

import designPattern.behaviour.strategyPattern.fix.algo.AuthAlgo;

import java.util.Random;

public class PassowrdAuthAlgo implements AuthAlgo {
    @Override
    public boolean authenticate(String userName, String password) {
        System.out.println("Doing Password authentication");
        return new Random().nextBoolean();

    }
}
