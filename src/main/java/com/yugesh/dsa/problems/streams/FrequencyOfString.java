package com.yugesh.dsa.problems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfString {

    static void main() {

        List<String> list = Arrays.asList("yugesh", "yugesh", "ravi", "sanjay", "ravi", "yugesh");

        Map<String, Long> map =
                list.stream()
                        .collect(
                                Collectors.groupingBy(
                                        words -> words, Collectors.counting()));

        System.out.println(map);
    }
}
