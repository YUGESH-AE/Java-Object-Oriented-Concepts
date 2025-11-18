package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import java.util.function.Predicate;

public class PredicateExample {

    static void main() {

        //without lambda
        Predicate<Integer>isEven=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        System.out.println(isEven.test(20));

        //with lambda
        Predicate<Integer>isOdd=(n)->n%2!=0;
        System.out.println(isOdd.test(21));
    }
}
