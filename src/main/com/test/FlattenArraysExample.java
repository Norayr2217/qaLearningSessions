package main.com.test;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlattenArraysExample {
    public static void main(String[] args) {
        String[][] data = {{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // Flattening the stream of arrays into a single stream of strings
        Stream<String> flattenedStream = Arrays.stream(data)
                                              .flatMap(Arrays::stream);

        flattenedStream.forEach(System.out::println);
    }
}