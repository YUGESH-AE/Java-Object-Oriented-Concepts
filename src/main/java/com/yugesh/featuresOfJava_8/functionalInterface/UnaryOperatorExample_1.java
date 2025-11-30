package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample_1 {

    static void main() {
        UnaryOperator<Double> unaryOperator = Math::sqrt;
        System.out.println(unaryOperator.apply(10.0));
    }
}
