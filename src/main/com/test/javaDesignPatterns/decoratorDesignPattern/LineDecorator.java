package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public class LineDecorator extends FishingRodDecorator {
    public LineDecorator(FishingRod fishingRod) {
        super(fishingRod);
    }

    @Override
    public String getDescription() {
        return fishingRod.getDescription() + ", + Durable Fishing Line";
    }

    @Override
    public double getCost() {
        return fishingRod.getCost() + 10.00;
    }
}
