package designPattern.behaviour.strategyPattern.fix;

import designPattern.behaviour.strategyPattern.fix.algo.RsaAuthAlgo;
import designPattern.behaviour.strategyPattern.fix.authenticator.AdminAuthenticator;
import designPattern.behaviour.strategyPattern.fix.authenticator.UserAuthenticator;

/**
 * The advantage of Strategy pattern is that on run time we can change the behaviour of a object
 * like in below example we have change the  admin authenticator to do rsa verfication
 */

public class Test {
    public static void main(String args[]) {

        AdminAuthenticator adminAuthenticator = new AdminAuthenticator();

        UserAuthenticator userAuthenticator = new UserAuthenticator();

        adminAuthenticator.authenticate();
        userAuthenticator.authenticate();

        adminAuthenticator.setAlgo(new RsaAuthAlgo());
        adminAuthenticator.authenticate();

    }
}
