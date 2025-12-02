package com.yugesh.featuresOfJava_8.streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * toArray() is a terminal stream operation that converts the elements of the stream into an array.
 */
public class ToArrayExample_1 {
    static void main() {

        //Basic toArray() (Object[])
        Object[] arr = Stream.of("a", "b", "c").toArray();
        System.out.println(Arrays.toString(arr));

        //Typed array using toArray(IntFunction)
        String[] strings = Stream.of("apple", "banana", "orange")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        //Using toArray(Integer[]::new)
        Integer[] nums = Stream.of(1, 2, 3, 4)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(nums));

        //int stream
        int[] s = IntStream.of(1, 2, 3).toArray();
        System.out.println(Arrays.toString(s));

        //double stream
        double[] d = DoubleStream.of(1.1, 2.2, 3.3).toArray();
        System.out.println(Arrays.toString(d));

        String[] n = Stream.of("java", "code", "ai", "chat")
                .filter(si -> si.length() > 2)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(n));


    }
}
