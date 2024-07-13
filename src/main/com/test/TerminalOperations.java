package test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntermediateOperations {

    public static void groupingBy(){
        List<String> items = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");

        Map<Character, List<String>> groupedByFirstLetter = items.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(groupedByFirstLetter);
        // Output: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
    }

    public static void partitioningBy(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitionedByEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitionedByEven);
        // Output: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
    }

    public static void mappingAndSummarizing(){
        List<String> phrases = Arrays.asList("hello world", "java streams", "functional programming");

        IntSummaryStatistics statistics = phrases.stream()
                .mapToInt(String::length)
                .summaryStatistics();

        System.out.println(statistics);
        // Output: IntSummaryStatistics{count=3, sum=45, min=11, average=15.0, max=19}
    }

    public static void creatingMapFromAList(){
        List<String> names = Arrays.asList("John", "Jane", "Jack");

        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println(nameLengthMap);
        // Output: {John=4, Jane=4, Jack=4}
    }
}
