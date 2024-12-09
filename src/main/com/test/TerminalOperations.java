package main.com.test;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static void groupingBy() {
        List<String> items = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");

        Map<Character, List<String>> groupedByFirstLetter = items.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(groupedByFirstLetter);
        // Output: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
    }

    public static void partitioningBy() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitionedByEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitionedByEven);
        // Output: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
    }

    public static void mappingAndSummarizing() {
        List<String> phrases = Arrays.asList("hello world", "java streams", "functional programming");

        IntSummaryStatistics statistics = phrases.stream()
                .mapToInt(String::length)
                .summaryStatistics();

        System.out.println(statistics);
        // Output: IntSummaryStatistics{count=3, sum=45, min=11, average=15.0, max=19}
    }

    public static void creatingMapFromAList() {
        List<String> names = Arrays.asList("John", "Jane", "Jack");

        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println(nameLengthMap);
        // Output: {John=4, Jane=4, Jack=4}
    }

    private static void anyMatchAndAllMatchOperator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyMatch = numbers.stream()
                .anyMatch(n -> n > 3);
        boolean allMatch = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("Any match greater than 3? " + anyMatch); // Output: Any match greater than 3? true
        System.out.println("All numbers greater than 0? " + allMatch); // Output: All numbers greater than 0? true
    }

    private static void countOperator() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();
        System.out.println("Count: " + count); // Output: Count: 2
    }

    private static void reduceOperator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
//                .reduce(0, Integer::sum); // also we can use method reference
                .reduce(0, (a, b) -> a + b); //the sum of all items
        System.out.println("Sum: " + sum); // Output: Sum: 15


        List<String> words = Arrays.asList("Java", "is", "awesome");
        String concatenated = words.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated string: " + concatenated); // Output: Concatenated string:  Java is awesome


        //The reduce method can also be used without an initial value,
        // in which case it returns an Optional because the result could be empty if the stream is empty:
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sumOptional = numbers1.stream()
                .reduce((a, b) -> a + b);
        int sum1 = sumOptional.orElse(0);
        System.out.println("Sum: " + sum1); // Output: Sum: 15
    }

    private static void optionalExample() {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 9, 1);

        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);

        max.ifPresent(value -> System.out.println("Max value: " + value)); // Output: Max value: 9

        Optional<Integer> min = numbers.stream()
                .min(Integer::compare);

        min.ifPresent(value -> System.out.println("Min value: " + value)); // Output: Min value: 1
    }

    public static void main(String[] args) {
        optionalExample();
    }
}
