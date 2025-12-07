package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReducingExample_1 {

    static void main() {
        // method_1();
        method_2();
        ;
    }

    /**
     * Performs a reduction on the stream elements using the given BinaryOperator,
     * inside a collector.
     * It’s similar to:
     * Sream.reduce(BinaryOperator)
     */
    public static void method_1() {

        // Find max number using reducing collector
        Optional<Integer> optInt = Stream.of(10, 20, 5)
                .collect(
                        Collectors.reducing(
                                Integer::max));
        System.out.println(optInt.get());

        // Concatenate strings
        Optional<String> optionalString = Stream.of("A", "B", "C")
                .collect(
                        Collectors.reducing(
                                (a, b) -> a + b));

        System.out.println(optionalString.get());

        // Use inside groupingBy()
        Map<Character, Optional<String>> map = Stream.of("apple", "ant", "axe", "bat")
                .collect(
                        Collectors.groupingBy(
                                w -> w.charAt(0),
                                Collectors.reducing(
                                        (s1, s2) -> s1.length() > s2.length() ? s1 : s2)));

        System.out.println(map);
    }

    /**
     * Collectors.reducing(identity, mapper, BinaryOperator)
     * Starts with an identity value
     * Applies a mapper to each element
     * <p>
     * Reduces all mapped values using BinaryOperator
     */
    public static void method_2() {

        // Sum string lengths
        int totalLength = Stream.of("apple", "ball", "cat")
                .collect(
                        Collectors.reducing(
                                0,
                                String::length,
                                Integer::sum));

        System.out.println(totalLength);

        // Reduce to maximum value after mapping
        int longest = Stream.of("apple", "ball", "cat")
                .collect(
                        Collectors.reducing(
                                0,
                                String::length,
                                Integer::max));

        System.out.println(longest);

        // Use inside groupingBy()
        Map<Character, Integer> result = Stream.of("apple", "bat", "ant")
                .collect(
                        Collectors.groupingBy(
                                s -> s.charAt(0),
                                Collectors.reducing(
                                        0,
                                        String::length,
                                        Integer::sum)));
        System.out.println(result);

        record Person(String name, int age) {
        }

        List<Person> people = List.of(
                new Person("Arun", 20),
                new Person("Vijay", 20),
                new Person("Yash", 30));

        Map<Integer, Integer> charCount = people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::age,
                                Collectors.reducing(
                                        0,
                                        p -> p.name().length(),
                                        Integer::sum)));

        System.out.println(charCount);
    }
}
