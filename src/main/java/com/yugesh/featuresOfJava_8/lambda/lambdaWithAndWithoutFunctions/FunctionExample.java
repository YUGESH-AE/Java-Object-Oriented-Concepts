package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import java.util.function.Function;

public class FunctionExample {

    static void main() {

        //Before Lambda
        Function<String,Integer>stringLength=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("Length of string before lambda:"+stringLength.apply("yugesh"));

        //After Lambda
        Function<String,Integer>lambda=s->s.length();

        System.out.println("Length of String after lambda:"+lambda.apply("yugesh"));


    }
}
