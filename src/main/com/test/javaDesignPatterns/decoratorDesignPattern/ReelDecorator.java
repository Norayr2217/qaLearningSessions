package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public class ReelDecorator extends FishingRodDecorator {
    public ReelDecorator(FishingRod fishingRod) {
        super(fishingRod);
    }

    @Override
    public String getDescription() {
        return fishingRod.getDescription() + ", + High-Quality Reel";
    }

    @Override
    public double getCost() {
        return fishingRod.getCost() + 15.00;
    }
}
