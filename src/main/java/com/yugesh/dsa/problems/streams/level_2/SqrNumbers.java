package com.yugesh.dsa.problems.streams.level_2;

import java.util.List;

public class SqrNumbers {
    static void main() {

        List<Integer> numbers = List.of(1, 2, 3, 4);

        List<Integer>square=numbers.stream()
                .map(n->n*n)
                .toList();
        System.out.println(square);

    }
}
