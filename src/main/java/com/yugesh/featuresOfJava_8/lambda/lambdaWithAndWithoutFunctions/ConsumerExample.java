package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import java.util.function.Consumer;

public class ConsumerExample {

    static void main() {

        //Before Lambda
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("I am printing the string:" + s);
            }
        };
        consumer.accept("yuesgh");

        //After Lambda
        Consumer<String> con = c -> System.out.println("I am printing the string:" + c);
        con.accept("ravi");
    }
}
