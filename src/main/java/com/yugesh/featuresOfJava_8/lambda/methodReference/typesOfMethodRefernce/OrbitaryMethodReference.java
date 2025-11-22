package com.yugesh.featuresOfJava_8.lambda.methodReference.typesOfMethodRefernce;

public class OrbitaryMethodReference {

    static void main() {

        Substraction substraction = OrbitaryMethodReference::sub;
        System.out.println(substraction.sub(new OrbitaryMethodReference(), 10, 20));
    }

    int sub(int a, int b) {
        return a + b;
    }


}
