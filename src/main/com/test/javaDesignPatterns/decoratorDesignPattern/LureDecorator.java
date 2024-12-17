package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public class LureDecorator extends FishingRodDecorator {
    public LureDecorator(FishingRod fishingRod) {
        super(fishingRod);
    }

    @Override
    public String getDescription() {
        return fishingRod.getDescription() + ", + Special Fishing Lure";
    }

    @Override
    public double getCost() {
        return fishingRod.getCost() + 8.00;
    }
}
