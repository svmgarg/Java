package designPattern.behaviour.observerPattern.subjects;

import designPattern.behaviour.observerPattern.Observer;
import designPattern.behaviour.observerPattern.Subject;

public class CricketData implements Subject {

    private long currentRuns;

    private int currentOvers;

    private int currentWickets;

    @Override
    public void registerObserver(Observer observer) {
        synchronized (MUTEX) {
            if (observer != null && !observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        synchronized (MUTEX) {
            if (observer != null && observers.contains(observer)) {
                observers.remove(observer);
            }
        }
    }

    @Override
    public void notifyObservers() {
        synchronized (MUTEX) {
            if (observers != null) {
                observers.forEach(Observer::update);
            }
        }
    }

    public void update(long currentRuns, int currentOvers, int currentWickets) {
        this.currentOvers = currentOvers;
        this.currentRuns = currentRuns;
        this.currentWickets = currentWickets;
        notifyObservers();
    }

    public long getCurrentRuns() {
        return currentRuns;
    }

    public void setCurrentRuns(long currentRuns) {
        this.currentRuns = currentRuns;
    }

    public int getCurrentOvers() {
        return currentOvers;
    }

    public void setCurrentOvers(int currentOvers) {
        this.currentOvers = currentOvers;
    }

    public int getCurrentWickets() {
        return currentWickets;
    }

    public void setCurrentWickets(int currentWickets) {
        this.currentWickets = currentWickets;
    }
}