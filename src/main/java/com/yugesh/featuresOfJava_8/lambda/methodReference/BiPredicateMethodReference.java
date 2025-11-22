package com.yugesh.featuresOfJava_8.lambda.methodReference;

import java.util.Objects;
import java.util.function.BiPredicate;

public class BiPredicateMethodReference {

    static void main() {

        BiPredicate<String, String> biPredicate = Objects::equals;
        System.out.println(biPredicate.test("yugesh", "raj"));
    }
}
