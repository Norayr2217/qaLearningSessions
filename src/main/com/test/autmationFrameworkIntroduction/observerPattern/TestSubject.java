package main.com.test.autmationFrameworkIntroduction.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class TestSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
