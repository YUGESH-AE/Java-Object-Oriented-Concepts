package com.yugesh.featuresOfJava_8.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * takeWhile() is an intermediate, short-circuiting operation that takes elements from the stream
 * UNTIL the predicate becomes false.
 * <p>
 * Once the predicate fails for the first time,
 * the stream stops immediately — even if later elements would pass.
 * Reading sorted or ordered data
 * <p>
 * Early stopping
 * <p>
 * When the order matters
 * <p>
 * Processing logs, files, or batch data until a trigger point
 */
public class TakeAWhileExample_1 {
    static void main() {

        //Basic behavior
        List<Integer> integerList = Stream.of(1, 2, 3, 0, 4, 5, 6, 7, 8)
                .takeWhile(n -> n > 0)
                .toList();
        System.out.println(integerList);

        //Stops at "bat" because predicate fails for the first time.
        var result = Stream.of("apple", "ant", "bat", "axis")
                .takeWhile(a -> a.startsWith("a"))
                .toList();
        System.out.println(result);

    }
}
