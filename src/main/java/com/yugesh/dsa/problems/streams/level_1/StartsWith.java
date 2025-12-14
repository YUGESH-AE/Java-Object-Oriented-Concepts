package com.yugesh.dsa.problems.streams.level_1;

import java.util.List;

public class StartsWith {
    static void main() {

        List<String> names = List.of("Adam", "Brian", "Alex", "Steve", "Ankit");

        List<String> startsWith = names.stream()
                .filter(s -> s.startsWith("A"))
                .toList();
        System.out.println(startsWith);

    }
}
