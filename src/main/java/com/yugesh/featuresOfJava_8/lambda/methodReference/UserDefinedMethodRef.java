package com.yugesh.featuresOfJava_8.lambda.methodReference;

@FunctionalInterface
interface Addition {
    int sum(int a, int b);
}

public class UserDefinedMethodRef {

    // A method reference is just a shorter way of writing a lambda expression when
    // the lambda only calls an existing method.
    // If a method already has the same method signature as the functional
    // interface’s single abstract method,
    // then we don't need to rewrite it.

    static void main() {

        Addition a = UserDefinedMethodRef::addition;

        System.out.println(a.sum(10, 20));

    }

    static int addition(int a, int b) {
        return a + b;
    }
}