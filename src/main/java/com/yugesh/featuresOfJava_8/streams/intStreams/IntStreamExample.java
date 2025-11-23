package com.yugesh.featuresOfJava_8.streams.intStreams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamExample {

    static void main() {

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 7, 8, 8);
        OptionalInt min = intStream.min();
        if (min.isPresent())
            System.out.println(min.getAsInt());
    }
}
