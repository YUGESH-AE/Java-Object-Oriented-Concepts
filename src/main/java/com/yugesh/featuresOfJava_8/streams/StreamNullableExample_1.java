package com.yugesh.featuresOfJava_8.streams;


import java.util.List;
import java.util.stream.Stream;

/**
 * Creates a stream of one element if the value is non-null,
 * otherwise returns an empty stream.
 * Avoids manual null checks and avoids NullPointerException.
 */
public class StreamNullableExample_1 {

    static void main() {

        //Nullable value
        String a = null;
        var s = Stream.ofNullable(null);
        System.out.println(s.toList());

        //Non-null value
        String name = "yugesh";
        var names = Stream.ofNullable(name);
        System.out.println(names.toList());

        //Use inside flatMap for safe operations
        //Essential trick in functional programming:
        List<String> result = Stream.of("A", null, "B")
                .flatMap(Stream::ofNullable)
                .toList();
        System.out.println(result);
    }
}
