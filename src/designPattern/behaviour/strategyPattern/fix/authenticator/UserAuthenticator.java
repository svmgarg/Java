package designPattern.behaviour.strategyPattern.fix.authenticator;

import designPattern.behaviour.strategyPattern.fix.algo.RsaAuthAlgo;
import designPattern.behaviour.strategyPattern.fix.authenticator.Authenticator;

/**
 * Here User authentication has to hide the extra method  password authentication
 */
public class UserAuthenticator extends Authenticator {


    public UserAuthenticator() {
        super.algo = new RsaAuthAlgo();
    }


}
