package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * findAny() is a terminal, short-circuiting stream operation that returns any one element from the stream,
 * wrapped in an Optional<T>.
 * On a sequential stream, it usually behaves like findFirst()
 * (but NOT guaranteed).
 * <p>
 * On a parallel stream, it returns any element quickly, not necessarily the first.
 * <p>
 * Often faster than findFirst() in parallel mode because it doesn't enforce order.
 * <p>
 * Returns empty Optional if the stream has no elements.
 */
public class FindAnyExample_1 {
    static void main() {

        //Basic findAny()
        var result = Stream.of("A", "B", "C")
                .findAny();

        System.out.println(result.get());

        //findAny() in a parallel stream (demonstrates difference)
        //Parallel streams show the real power of findAny()
        // — return quickly without worrying about order.
        var parallelResult = Stream.of("A", "B", "C")
                .parallel()
                .findAny();

        System.out.println(parallelResult.get());

        //findAny() after filtering
        var name = Stream.of("java", "code", "chat")
                .filter(s -> s.startsWith("c"))
                .findAny()
                .orElse("No match");

        System.out.println(name);


    }
}
