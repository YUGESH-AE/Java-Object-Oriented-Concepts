package com.yugesh.dsa.problems.streams.level_1;

import java.util.List;

public class EvenNumbers {

    static void main() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evenNumbers);

    }
}
