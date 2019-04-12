package designPattern.behaviour.strategyPattern.fix.authenticator;


import designPattern.behaviour.strategyPattern.fix.algo.AuthAlgo;

import java.util.Random;

public class Authenticator {

    String token;
    String userName;

    AuthAlgo algo;

    public boolean authenticate() {
        algo.authenticate(userName, token);
        return new Random().nextBoolean();
    }

    public AuthAlgo getAlgo() {
        return algo;
    }

    public void setAlgo(AuthAlgo algo) {
        this.algo = algo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}