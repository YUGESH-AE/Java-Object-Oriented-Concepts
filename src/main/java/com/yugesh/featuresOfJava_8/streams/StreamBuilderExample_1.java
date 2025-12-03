package com.yugesh.featuresOfJava_8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Creates a Stream.Builder, a mutable builder object used to construct a stream
 * A builder works like adding items into a basket and then sealing it into a stream.
 */
public class StreamBuilderExample_1 {

    static void main() {

        //Manually building a stream
        Stream.Builder<String> builder = Stream.builder();
        builder.add("A");
        builder.add("B");
        builder.add("C");
        builder.add("D");
        builder.add("E");

        Stream<String> s = builder.build();
        System.out.println(Arrays.asList(s.toArray()));


        //Building conditionally
        Stream.Builder<Integer> integerBuilder = Stream.builder();

        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) {
                integerBuilder.add(i);
            }
        }
        System.out.println(Arrays.toString(integerBuilder.build().toArray()));
    }
}
