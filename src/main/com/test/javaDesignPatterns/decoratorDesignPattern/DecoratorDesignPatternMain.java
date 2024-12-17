package main.com.test.javaDesignPatterns.decoratorDesignPattern;

public class DecoratorDesignPatternMain {
        public static void main(String[] args) {
        FishingRod myRod = new BasicFishingRod();
        System.out.println(myRod.getDescription() + " is " + myRod.getCost() + "$");
        System.out.println();

        myRod = new ReelDecorator(myRod);
        System.out.println(myRod.getDescription() + " is " + myRod.getCost() + "$");
        System.out.println();

        myRod = new LineDecorator(myRod);
        System.out.println(myRod.getDescription() + " is " + myRod.getCost() + "$");
        System.out.println();

        myRod = new LureDecorator(myRod);
        System.out.println(myRod.getDescription() + " is " + myRod.getCost() + "$");
    }
}
