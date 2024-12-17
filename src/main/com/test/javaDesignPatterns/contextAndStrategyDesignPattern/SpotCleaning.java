package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class SpotCleaning implements CleaningStrategy {
    @Override
    public void clean() {
        System.out.println("Performing Spot Cleaning.");
    }
}
