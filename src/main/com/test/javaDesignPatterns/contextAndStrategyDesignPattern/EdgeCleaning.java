package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class EdgeCleaning implements CleaningStrategy {
    @Override
    public void clean() {
        System.out.println("Performing Edge Cleaning.");
    }
}