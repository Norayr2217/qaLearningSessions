package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class NormalCleaning implements CleaningStrategy {
    @Override
    public void clean() {
        System.out.println("Performing Normal Cleaning.");
    }
}
