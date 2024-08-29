package test;

import java.util.function.*;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
//        // Function<T, R>
//        Function<String, Integer> stringLength = String::length;
//        Function<Integer, Integer> doubleValue = x -> x * 2;
//        Function<String, Integer> lengthAndDouble = stringLength.andThen(doubleValue);
//        System.out.println(lengthAndDouble.apply("Hello")); // 10

//         Consumer<T>
//        Consumer<String> print = System.out::println;
//        Consumer<String> printUpper = x -> System.out.println(x.toUpperCase());
//        Consumer<String> printAndUpper = print.andThen(printUpper);
//        printAndUpper.accept("hello"); // prints "hello" and "HELLO"
//
//        // Supplier<T>
//        Supplier<String> supplier = () -> "Hello";
//        System.out.println(supplier.get()); // Hello
//
//        // BiFunction<T, U, R>
//        BiFunction<String, String, Integer> concatenateAndLength = (x, y) -> (x + y).length();
//        Function<Integer, Integer> addFive = x -> x + 5;
//        BiFunction<String, String, Integer> concatenateLengthAndAddFive = concatenateAndLength.andThen(addFive);
//        System.out.println(concatenateLengthAndAddFive.apply("Hello", "World")); // 15
//
//        // BiConsumer<T, U>
//        BiConsumer<String, String> printBoth = (x, y) -> System.out.println(x + " " + y);
//        BiConsumer<String, String> printBothUpper = (x, y) -> System.out.println(x.toUpperCase() + " " + y.toUpperCase());
//        BiConsumer<String, String> printBothAndUpper = printBoth.andThen(printBothUpper);
//        printBothAndUpper.accept("Hello", "World"); // prints "Hello World" and "HELLO WORLD"
//
//        // Predicate<T>
//        Predicate<Integer> isPositive = x -> x > 0;
//        Predicate<Integer> isLessThanTen = x -> x < 10;
//        Predicate<Integer> isEven = x -> x % 2 == 0;
//
//        Predicate<Integer> complexPredicate = isPositive.and(isLessThanTen).or(isEven).negate();
//
//        System.out.println(complexPredicate.test(5));
//        System.out.println(complexPredicate.test(12));
//        System.out.println(complexPredicate.test(-3));
//        System.out.println(complexPredicate.test(11));
//
//        // BiPredicate<T, U>
//        BiPredicate<Integer, Integer> isGreater = (x, y) -> x > y;
//        BiPredicate<Integer, Integer> bothLessThanTen = (x, y) -> x < 10 && y < 10;
//        BiPredicate<Integer, Integer> sumIsEven = (x, y) -> (x + y) % 2 == 0;
//
//        BiPredicate<Integer, Integer> complexBiPredicate = isGreater.and(bothLessThanTen).or(sumIsEven).negate();
//
//        System.out.println(complexBiPredicate.test(5, 3));
//        System.out.println(complexBiPredicate.test(12, 2)); // false
//        System.out.println(complexBiPredicate.test(15, 20)); // true
//        System.out.println(complexBiPredicate.test(9, 9)); //false

        andThen();
        compose();
    }

    private static void andThen() {
        Function<Integer, Integer> plusTwo = i -> i + 2;
        Function<Integer, Integer> square = i -> i * i;

        Integer apply = plusTwo.andThen(square).apply(8);

        System.out.println(apply);
    }

    private static void compose() {
        Function<Integer, Integer> plusTwo = i -> i + 2;
        Function<Integer, Integer> square = i -> i * i;

        Integer apply = plusTwo.compose(square).apply(8);

        System.out.println(apply);
    }
}