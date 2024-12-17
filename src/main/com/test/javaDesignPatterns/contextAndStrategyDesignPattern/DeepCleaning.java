package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class DeepCleaning implements CleaningStrategy {
    @Override
    public void clean() {
        System.out.println("Performing Deep Cleaning.");
    }
}
