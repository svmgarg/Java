package designPattern.behaviour.strategyPattern.fix.authenticator;


import designPattern.behaviour.strategyPattern.fix.algo.PassowrdAuthAlgo;

/**
 * Here Admin authentication has to hide the extra method  rsa authentication
 */
public class AdminAuthenticator extends Authenticator {


    public AdminAuthenticator(){
        super.algo = new PassowrdAuthAlgo();
    }
}
