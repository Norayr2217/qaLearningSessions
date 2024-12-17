package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public abstract class FishingRodDecorator implements FishingRod {
    protected FishingRod fishingRod;

    public FishingRodDecorator(FishingRod fishingRod) {
        this.fishingRod = fishingRod;
    }

    @Override
    public String getDescription() {
        return fishingRod.getDescription();
    }

    @Override
    public double getCost() {
        return fishingRod.getCost();
    }
}
