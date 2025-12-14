package com.yugesh.dsa.problems.streams.level_4;

import java.util.List;

public class AllNumbersPossitive {
    static void main() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7, -1, -2);

        boolean isPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println(isPositive);
    }
}
