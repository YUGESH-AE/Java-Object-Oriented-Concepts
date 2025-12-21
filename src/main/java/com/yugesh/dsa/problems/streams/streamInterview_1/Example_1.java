package com.yugesh.dsa.problems.streams.streamInterview_1;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example_1 {
    static void main() {

        //sum of given numbers
        System.out.println(sumOfNumbers(List.of(1, 3, 5, 6, 7, 3, 4, 34, 21, 123, 4, 5, 6)));

        //average of numbers
        System.out.println(averageOfNumbers(List.of(1, 2, 3, 4, 5)));

        //square numbers, filter greater than 100 and then average
        System.out.println(average(List.of(1, 10, 20, 30, 15)));

        //print odd and even
        System.out.println(oddAndEven(List.of(11, 23, 57, 3, 59, 36, 80)));

        //Print Numbers Starts With Prefix 2 using Streams
        System.out.println(printPrefix_2(List.of(2, 222, 234, 567, 890, 432, 236, 211, 22)));

        //Print Duplicate Numbers using Streams
        System.out.println(printDuplicateNumbers(List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 30, 19, 3)));

        //find the maximum and the minimum number in the list
        maxAndMinNumber(List.of(1, 3, 10, 39, 689, 23, 12, 34, 56, 78, 89));

        //find the second highest and lowest numbers
        secondHighestLowest(List.of(0, 3, 10, 20, 30, 15, 1, 13, 15, 1, 2, 2, 10, 19, 3, 30));

    }


    public static List<Integer> printDuplicateNumbers(List<Integer> list) {

        return list.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void maxAndMinNumber(List<Integer> list) {

        DoubleSummaryStatistics summaryStatistics =
                list.stream()
                        .collect(
                                Collectors.summarizingDouble(Integer::doubleValue)
                        );

        System.out.println("Min number: " + summaryStatistics.getMin());
        System.out.println("Max Numbers:" + summaryStatistics.getMax());
    }

    public static void secondHighestLowest(List<Integer> list) {

        int secondHighest = list
                .stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst().get();
        System.out.println("Second Highest:" + secondHighest);

        int secondLowest = list
                .stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst().get();

        System.out.println("Second Lowest:" + secondLowest);
    }

    public static int sumOfNumbers(List<Integer> list) {

        return list.stream()
                .reduce(0, Integer::sum);
    }

    public static double averageOfNumbers(List<Integer> list) {

        return list
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static double average(List<Integer> list) {

        return list.stream()
                .mapToInt(Integer::intValue)
                .map(n -> n * n)
                .filter(n -> n > 100)
                .average()
                .orElse(0.0);
    }

    public static Map<String, List<Integer>> oddAndEven(List<Integer> list) {

        return list.stream()
                .collect(
                        Collectors.groupingBy(
                                n -> n % 2 == 0 ? "Even" : "Odd"
                        )
                );
    }

    public static List<Integer> printPrefix_2(List<Integer> list) {

        return list.stream()
                .map(String::valueOf)
                .filter(n -> n.startsWith("2"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }


}
