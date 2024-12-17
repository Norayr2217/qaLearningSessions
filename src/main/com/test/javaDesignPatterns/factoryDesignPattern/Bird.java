package main.com.test.javaDesignPatterns.factoryDesignPattern;

public class Bird implements Pet {
    @Override
    public void makeNoise() {
        System.out.println("Bird - civ-civ");
    }
}
