package main.com.test.lamdaAndStreams;

import java.util.function.Function;

public class FirstClassFunctionExample {
    public static void main(String[] args) {
        // Function as a first-class object
        Function<Integer, Integer> square = x -> x * x;

        // Using the function
        int result = square.apply(5);
        System.out.println("Square of 5 is: " + result);
    }
}