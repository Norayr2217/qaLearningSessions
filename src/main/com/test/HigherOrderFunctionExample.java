package main.com.test;

import java.util.function.Function;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {
        // Higher-order function: takes a function as an argument and returns a function
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> doubleValue = x -> x * 2;

        // Compose functions: double and then increment
        Function<Integer, Integer> doubleThenIncrement = doubleValue.andThen(increment);

        // Using the higher-order function
        int result = doubleThenIncrement.apply(3);
        System.out.println("Result of doubleThenIncrement(3): " + result);
    }
}