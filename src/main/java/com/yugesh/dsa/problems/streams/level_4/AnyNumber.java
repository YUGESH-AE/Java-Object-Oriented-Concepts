package com.yugesh.dsa.problems.streams.level_4;

import java.util.List;

public class AnyNumber {
    static void main() {

        List<Integer> numbers=List.of(1,2,3,4,5,7,-1,-2,500,1000,200,300);

        Integer i=numbers.stream()
                .filter(n->n>100)
                .findAny().orElse(0);

        System.out.println(i);



    }
}
