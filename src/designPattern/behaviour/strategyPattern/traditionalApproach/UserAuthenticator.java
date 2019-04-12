package designPattern.behaviour.strategyPattern.traditionalApproach;

/**
 * Here User authentication has to hide the extra method  password authentication
 */
public class UserAuthenticator extends  Authenticator {


    @Override
    public boolean passwordAuthentication() {
        System.out.println("Password authentication is only for admins");
        return false;
    }

}
