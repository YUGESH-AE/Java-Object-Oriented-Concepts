package com.yugesh.featuresOfJava_8.lambda.methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReference {

    static void main() {

        List<Integer> list = Arrays.asList(909, 56, 34, 889, 123, 45, 675, 8981);

        Consumer<List<Integer>> consumer = Collections::sort;
        consumer.accept(list);
        System.out.println(list);
    }
}
