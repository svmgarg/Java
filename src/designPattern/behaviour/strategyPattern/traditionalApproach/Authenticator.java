package designPattern.behaviour.strategyPattern.traditionalApproach;


import java.util.Random;

public class Authenticator {

    String token;
    String userName;


    public boolean passwordAuthentication() {

        System.out.println("doing passowrd authentication");
        return new Random().nextBoolean();
    }


    public boolean rsaAuthentication() {

        System.out.println("doing passowrd authentication");
        return new Random().nextBoolean();
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