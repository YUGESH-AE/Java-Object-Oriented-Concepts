package com.yugesh.featuresOfJava_8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamStaticMethodExamples_1 {

    static void main() {

        //Creates an empty stream with zero elements.
        Stream<String> empty = Stream.empty();
        System.out.println(empty.count());

        //Creates a stream from the given values (varargs).
        Stream<String> s = Stream.of("array", "list");
        System.out.println(Arrays.toString(s.toArray()));

        //Same as above but with a single value.
        Stream<Integer> i = Stream.of(100);
        System.out.println(Arrays.stream(i.toArray()));

        //Creates an infinite stream from a supplier — each element is generated dynamically.
        Stream<Double> stream = Stream.generate(Math::random)
                .limit(5);
        System.out.println(Arrays.toString(stream.toArray()));
        Stream<String> hello = Stream.generate(() -> "Hi")
                .limit(3);
        System.out.println(Arrays.toString(hello.toArray()));

        //Generate numbers 1 to 5
        Stream<Integer> integerStream = Stream.iterate(1, n -> n * 2)
                .limit(10);
        System.out.println(Arrays.toString(integerStream.toArray()));

        var integerStream1 = Stream.iterate(0, n -> n <= 5, n -> n + 1)
                .toList();
        System.out.println(integerStream1);

    }
}
