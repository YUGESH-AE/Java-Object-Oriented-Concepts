package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample_1 {

    static void main() {
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(10, 20));
    }
}
