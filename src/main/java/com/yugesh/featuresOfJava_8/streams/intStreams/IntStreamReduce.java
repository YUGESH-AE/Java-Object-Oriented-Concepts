package com.yugesh.featuresOfJava_8.streams.intStreams;

import java.util.stream.IntStream;

public class IntStreamReduce {
    static void main() {

        IntStream intStream = IntStream.of(10, 20, 40, 14, 1, 2, 3, 4, 5);

//        //Method 1 without initial value
//        OptionalInt optional=
//                intStream.reduce(Integer::sum);
//        if(optional.isPresent())
//            System.out.println(optional.getAsInt());

        //Method 2 with initial value

        System.out.println(intStream.reduce(0, Integer::sum));

    }
}
