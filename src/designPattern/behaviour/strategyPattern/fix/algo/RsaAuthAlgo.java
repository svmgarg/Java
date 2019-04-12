package designPattern.behaviour.strategyPattern.fix.algo;

import designPattern.behaviour.strategyPattern.fix.algo.AuthAlgo;

import java.util.Random;

public class RsaAuthAlgo implements AuthAlgo {
    @Override
    public boolean authenticate(String userName, String password) {
        System.out.println("Doing Rsa authentication");
        return new Random().nextBoolean();

    }
}
