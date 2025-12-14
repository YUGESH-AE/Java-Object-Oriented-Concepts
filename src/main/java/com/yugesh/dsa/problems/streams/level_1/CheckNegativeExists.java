package com.yugesh.dsa.problems.streams.level_1;

import java.util.List;

public class CheckNegativeExists {

    static void main() {
        List<Integer> numbers = List.of(5, 10, -2, 8);

        boolean exists = numbers.stream()
                .anyMatch(n -> n < 0);
        System.out.println(exists);

    }
}
