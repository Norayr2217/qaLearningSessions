package main.com.test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        limitAndSkip();
    }

    private static void onlyIntermediateOperator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> integerStream = numbers.stream().filter(number -> number < 4);
        integerStream.forEach(item -> System.out.println(item));

    }

    public static void limitAndSkip() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limitedNumbers = numbers.stream()
                .peek(i -> System.out.println("I am in a stream loop"))
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(limitedNumbers);
    }

    public static void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct() //removes duplicates
                .collect(Collectors.toList());
        System.out.println(distinctNumbers); // Output: [1, 2, 3, 4, 5]
    }

    public static void sorting() {
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNames); // Output: [Alice, Bob, Charlie]
    }

    public static void mapping() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(nameLengths); // Output: [5, 3, 7]
    }

    public static void filtering() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emma");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println(filteredNames); // Output: [Alice, Charlie, David]
    }
}
