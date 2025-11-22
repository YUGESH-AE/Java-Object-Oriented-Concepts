package com.yugesh.featuresOfJava_8.lambda.methodReference.typesOfMethodRefernce;

public class StaticMethodReference {

    static void main() {

        Addition add = StaticMethodReference::addition;
        System.out.println(add.sum(10, 10));
    }

    static int addition(int a, int b) {
        return a + b;
    }
}
