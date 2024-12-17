package main.com.test.javaDesignPatterns.contextAndStrategyDesignPattern;

public class RobotVacuumContext {
    private CleaningStrategy cleaningStrategy;

    public void setCleaningStrategy(CleaningStrategy cleaningStrategy) {
        this.cleaningStrategy = cleaningStrategy;
    }

    public void startCleaning() {
        if (cleaningStrategy != null) {
            cleaningStrategy.clean();
        } else {
            System.out.println("No strategy set.");
        }
    }
}
