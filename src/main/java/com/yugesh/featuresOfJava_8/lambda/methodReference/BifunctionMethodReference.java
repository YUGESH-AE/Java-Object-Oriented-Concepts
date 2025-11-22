package com.yugesh.featuresOfJava_8.lambda.methodReference;

import java.util.function.BiFunction;

public class BifunctionMethodReference {

    static void main() {

        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;
        System.out.println(biFunction.apply(10, 20));
    }
}
