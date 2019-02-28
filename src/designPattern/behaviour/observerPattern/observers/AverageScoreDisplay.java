package designPattern.behaviour.observerPattern.observers;

import designPattern.behaviour.observerPattern.Observer;
import designPattern.behaviour.observerPattern.subjects.CricketData;

public class AverageScoreDisplay implements Observer {


    final private CricketData cricketData;

    public AverageScoreDisplay(CricketData cricketData) {
        this.cricketData = cricketData;
    }

    @Override
    public void update() {
        display();
    }

    public void display(){
        System.out.println("Average score is " + cricketData.getCurrentRuns()/cricketData.getCurrentOvers());
    }

}
