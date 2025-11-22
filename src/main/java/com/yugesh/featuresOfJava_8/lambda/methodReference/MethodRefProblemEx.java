package com.yugesh.featuresOfJava_8.lambda.methodReference;

@FunctionalInterface
interface Show {
    void print(String s);
}

public class MethodRefProblemEx {

    static void main() {
        Show s = MethodRefProblemEx::display;
        s.print("yugesh");

    }

    public static String display(String v) {
        System.out.println(v);
        return v;
    }
}