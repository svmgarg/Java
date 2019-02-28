package designPattern.behaviour.observerPattern.observers;


import designPattern.behaviour.observerPattern.Observer;
import designPattern.behaviour.observerPattern.subjects.CricketData;

public class CurrentScoreDisplay implements Observer {

    final private CricketData cricketData;

    public CurrentScoreDisplay(CricketData cricketData) {
        this.cricketData = cricketData;
    }

    @Override
    public void update() {
        display();
    }

    public void display(){
        System.out.println("Current score is " + cricketData.getCurrentRuns());
    }

}
