package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public class BasicFishingRod implements FishingRod {
    @Override
    public String getDescription() {
        return "Basic Fishing Rod";
    }

    @Override
    public double getCost() {
        return 20.00;
    }
}
