package main.com.test.javaDesignPatterns.factoryDesignPattern;

public class Dog implements Pet {
    @Override
    public void makeNoise() {
        System.out.println("Dog - haf-haf");
    }
}
