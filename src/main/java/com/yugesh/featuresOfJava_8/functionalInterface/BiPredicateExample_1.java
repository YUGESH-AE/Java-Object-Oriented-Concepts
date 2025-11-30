package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateExample_1 {

    static void main() {
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        System.out.println(biPredicate.test(10, 20));
    }
}
