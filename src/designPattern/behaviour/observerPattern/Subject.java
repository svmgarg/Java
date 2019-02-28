package designPattern.behaviour.observerPattern;


import java.util.ArrayList;
import java.util.List;

public interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();

    List<Observer> observers = new ArrayList();

    Object MUTEX = new Object();
}
