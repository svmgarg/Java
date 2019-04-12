package designPattern.behaviour.strategyPattern.traditionalApproach;


/**
 * Here Admin authentication has to hide the extra method  rsa authentication
 */
public class AdminAuthenticator extends  Authenticator {

    @Override
    public boolean rsaAuthentication() {
        System.out.println("RSA authentication is only for Users");

        return false;
    }
}
