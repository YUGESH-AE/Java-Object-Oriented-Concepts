package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample_1 {
    static void main() {

        Predicate<Integer> predicate = n -> n % 2 == 0;
        Integer i = 10;
        if (predicate.test(i)) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
