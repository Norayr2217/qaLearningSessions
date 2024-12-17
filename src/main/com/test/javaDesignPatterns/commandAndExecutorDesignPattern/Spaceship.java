package main.com.test.javaDesignPatterns.commandAndExecutorDesignPattern;

public class Spaceship {
    public void accelerate() {
        System.out.println("Spaceship is accelerating.");
    }

    public void turn(int angle) {
        System.out.println("Spaceship is turning " + angle + " degrees.");
    }

    public void hyperjump() {
        System.out.println("Spaceship is hyperjumping");
    }
}
