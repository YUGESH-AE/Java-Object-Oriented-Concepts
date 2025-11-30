package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.BiConsumer;

public class BiConsumerExample_1 {

    static void main() {
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);

        biConsumer.accept(10, 20);
    }
}
