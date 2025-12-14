package com.yugesh.dsa.problems.streams.level_3;

import java.util.List;

public class EvenNumberSquare {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        List<Integer> evenSquare =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .toList();
        System.out.println(evenSquare);
    }
}
