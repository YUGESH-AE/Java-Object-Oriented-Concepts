package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * skip() is an intermediate, stateful stream operation that
 * returns a stream with the first n elements removed, and the rest passed downstream.
 * Skips (drops) first N elements.
 * <p>
 * Often used for pagination with limit().
 * <p>
 * Does not short-circuit by itself (it still needs to check and skip N elements).
 */
public class SkipExample_1 {

    static void main() {

        //Basic skip()
        var after2 = Stream.of(10, 20, 30, 40)
                .skip(2)
                .toList();
        System.out.println(after2);

        //Skipping on infinite stream
        var infinite = Stream.iterate(0, n -> n + 1)
                .skip(20)
                .limit(10)
                .toList();
        System.out.println(infinite);
    }
}
