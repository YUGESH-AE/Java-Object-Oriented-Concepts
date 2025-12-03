package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupByExample_1 {

    static void main() {

//        collectors_GroupBy();
        collectors_Mapping();

    }

    public static void collectors_GroupBy() {
        method_1();
        method_2();
        method_3();
    }


    /**
     * Collectors.groupingBy(Function classifier)
     * <p>
     * Groups stream elements into a Map<K, List<T>>, where:
     * <p>
     * K = the key produced by the classifier function
     * <p>
     * List<T> = list of items belonging to that key
     */
    public static void method_1() {

        //Group strings by length
        Map<Integer, List<String>> groupByString =
                Stream.of("Java", "Angular", "React", "Ai", "react", "python", "Spring")
                        .collect(Collectors.groupingBy(String::length));
        System.out.println(groupByString);

        //Group numbers by even/odd
        Map<String, List<Integer>> intGroupBy = Stream
                .iterate(0, n -> n + 1)
                .limit(10)
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(intGroupBy);
    }

    /**
     * Collectors.groupingBy(Function classifier, Collector downstream)
     * This version lets you customize how each group is collected.
     * Instead of producing List<T>, you can produce:
     * <p>
     * Set<T>
     * <p>
     * Count (Long)
     * <p>
     * Map
     * <p>
     * Joining string
     * <p>
     * Custom reduction, etc.
     */
    public static void method_2() {

        //Count elements in each group
        //Group words by first letter, count how many:
        Map<Character, Long> result = Stream.of("Apple", "ant", "Ball", "cat")
                .collect(
                        Collectors.groupingBy(
                                w -> w.charAt(0),
                                Collectors.counting()
                        )
                );

        System.out.println(result);

        //Convert each group to a Set (no duplicates)
        Map<Integer, Set<String>> resultSet =
                Stream.of("java", "ai", "code", "api", "api", "java")
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        Collectors.toSet()
                                )
                        );
        System.out.println(resultSet);
    }

    /**
     * Collectors.groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
     * (Advanced version)
     * <p>
     * This version allows full control:
     * <p>
     * How keys are generated
     * <p>
     * What map implementation is used (e.g., TreeMap, LinkedHashMap, ConcurrentMap)
     * <p>
     * What collector is used to reduce group values
     */
    public static void method_3() {

        //Use TreeMap (sorted keys)
        Map<Integer, List<String>> sortedKeys =
                Stream.of("java", "stream", "ai")
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        TreeMap::new,
                                        Collectors.toList()
                                )
                        );

        System.out.println(sortedKeys);

        Map<Character, Long> linkedHashMapGrouping =
                Stream.of("apple", "ant", "bat", "ball")
                        .collect(
                                Collectors.groupingBy(
                                        w -> w.charAt(0),
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                )
                        );

        System.out.println(linkedHashMapGrouping);


        record User(int age, String name) {
        }
        List<User> users = List.of(
                new User(20, "Arun"),
                new User(20, "Vijay"),
                new User(30, "Yash")
        );

        Map<Integer, Set<String>> groupByAge =
                users.stream()
                        .collect(
                                Collectors.groupingBy(
                                        User::age,
                                        HashMap::new,
                                        Collectors.mapping(
                                                User::name,
                                                Collectors.toSet()
                                        )
                                )
                        );

        System.out.println(groupByAge);
    }

    public static void collectors_Mapping() {
        method_1_Mapping();
    }

    /**
     * Collectors.mapping() lets you apply a map() inside a grouping or partitioning collector.
     * mapper → transforms the input element
     * <p>
     * downstream → collects the transformed element
     */
    public static void method_1_Mapping() {

        //Group names by length
        //
        //Instead of grouping strings themselves, we group their uppercase form.

        Map<Integer, List<String>> groupByString =
                Stream.of("apple", "ant", "bat")
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        Collectors.mapping(
                                                String::toUpperCase,
                                                Collectors.toList()
                                        )
                                )
                        );

        System.out.println(groupByString);

        //Group people by age → collect only names
        record Person(String name, int age) {
        }

        List<Person> people = List.of(
                new Person("Arun", 20),
                new Person("Vijay", 20),
                new Person("Yash", 30)
        );
        Map<Integer, List<String>> groupByAgeAndNames =
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::age,
                                        HashMap::new,
                                        Collectors.mapping(
                                                Person::name,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println(groupByAgeAndNames);


        //Group by starting letter, but only get string lengths
        Map<Character, List<Integer>> groupByCharacter =
                Stream.of("java", "chat", "apple")
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.charAt(0),
                                        HashMap::new,
                                        Collectors.mapping(
                                                String::length,
                                                Collectors.toList()
                                        )

                                )
                        );
        System.out.println(groupByCharacter);
    }
}
