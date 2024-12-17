package main.com.test.autmationFrameworkIntroduction.observerPattern;

public interface Subject {
    void addObserver(Observer observer);
    void notifyObservers();
}
