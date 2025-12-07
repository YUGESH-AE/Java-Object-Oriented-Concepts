package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.Function;

public class FunctionExample_1 {
    static void main() {

        Function<String, Integer> function = String::length;

        System.out.println(function.apply("yugesh"));

        // function and then
        Function<String, String> notNull = s -> s == null ? "Enter something" : s;
        Function<String, String> uppercase = String::toUpperCase;

        System.out.println(notNull.andThen(uppercase).apply("ravi"));
    }
}
