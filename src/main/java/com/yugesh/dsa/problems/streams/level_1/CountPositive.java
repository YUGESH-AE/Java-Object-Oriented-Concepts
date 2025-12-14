package com.yugesh.dsa.problems.streams.level_1;

import java.util.List;

public class CountPositive {

    static void main() {

        List<Integer> numbers = List.of(-3, -1, 0, 2, 4, 7);

        long positive=numbers.stream()
                .filter(n->n>0)
                .count();
        System.out.println(positive);


    }
}
