package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionExample_1 {

    static void main() {
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;

        System.out.println(biFunction.apply(10, 20));
    }
}
