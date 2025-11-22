package com.yugesh.featuresOfJava_8.lambda.methodReference.typesOfMethodRefernce;

public class ReferenceMethodReference {

    static void main() {

        Addition add = new ReferenceMethodReference()::addition;
        System.out.println(add.sum(10, 10));
    }

    int addition(int a, int b) {
        return a + b;
    }
}

