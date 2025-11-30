package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample_1 {

    static void main() {

        List<String> list = new ArrayList<>();
        list.add("yugesh");
        list.add("java");
        list.add("angular");
        list.add("react");

        Consumer<String> consumer = System.out::println;

        list.forEach(consumer);
    }
}
