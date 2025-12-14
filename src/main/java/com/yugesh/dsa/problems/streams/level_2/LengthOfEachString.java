package com.yugesh.dsa.problems.streams.level_2;

import java.util.List;

public class LengthOfEachString {

    static void main() {

        List<String> names = List.of("Java", "Stream", "API");

        List<Integer> lengths = names.stream()
                .map(String::length).toList();
        System.out.println(lengths);

    }
}
