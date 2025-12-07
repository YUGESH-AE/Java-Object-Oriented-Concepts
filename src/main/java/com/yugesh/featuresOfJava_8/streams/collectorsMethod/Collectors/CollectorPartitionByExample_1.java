package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorPartitionByExample_1 {

    static void main() {
        method_1();
        method_2();
    }

    /**
     * Collectors.partitioningBy(Predicate)
     * Partitions a stream into two lists based on the given predicate.
     * key true → elements matching the predicate
     * key false → elements NOT matching the predicate
     */
    public static void method_1() {

        // Partition numbers into even and odd
        Map<Boolean, List<Integer>> mapResult = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .collect(
                        Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(mapResult);

        // Partition strings by length > 3
        Map<Boolean, List<String>> resultString = Stream.of("java", "api", "chat", "angular")
                .collect(
                        Collectors.partitioningBy(n -> n.length() > 3));

        System.out.println(resultString);

        record Emp(String name, double salary) {
        }

        List<Emp> employees = List.of(
                new Emp("Arun", 45000),
                new Emp("Vikram", 60000),
                new Emp("Yash", 55000));

        Map<Boolean, List<Emp>> emplMap = employees.stream()
                .collect(
                        Collectors.partitioningBy(emp -> emp.salary() > 5000));
        System.out.println(emplMap);

    }

    /**
     * Collectors.partitioningBy(Predicate, Collector)
     * Same partitioning logic, BUT allows you to decide how to collect values in
     * each partition.
     */
    public static void method_2() {

        // Count items in each partition
        Map<Boolean, Long> result = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0,
                        Collectors.counting()));

        System.out.println(result);

        // Partition strings → convert each group into Set
        Map<Boolean, Set<String>> resultSet = Stream.of("java", "api", "chat", "code")
                .collect(
                        Collectors.partitioningBy(
                                s -> s.length() > 3,
                                Collectors.toSet()));

        System.out.println(resultSet);

        // Partition words → join each partition into a string
        Map<Boolean, String> resultSrting = Stream.of("apple", "ant", "bat", "ball")
                .collect(
                        Collectors.partitioningBy(
                                s -> s.startsWith("a"),
                                Collectors.joining(",", "[", "]")));

        System.out.println(resultSrting);

        record Emp(String name, double salary) {
        }

        List<Emp> employees = List.of(
                new Emp("Arun", 45000),
                new Emp("Vikram", 60000),
                new Emp("Yash", 55000));

        Map<Boolean, List<String>> emplMap = employees.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.salary() > 5000,
                                Collectors.mapping(
                                        Emp::name,
                                        Collectors.toList())));

        System.out.println(emplMap);
    }

}
