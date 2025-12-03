package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collects stream elements into a mutable Set (usually a HashSet).
 * Removes duplicates automatically
 * <p>
 * Order is not guaranteed
 * <p>
 * Creates an unmodifiable Set (cannot add/remove elements).
 */
public class CollectorsToSetExample_1 {

    static void main() {


        Set<Integer> set = Stream.of(1, 2, 2, 3)
                .collect(Collectors.toSet());

        set.add(4);
        System.out.println(set);


        Set<String> sets = Stream.of("A", "B", "B")
                .collect(Collectors.toUnmodifiableSet());

//        sets.remove("A");   // ❌ UnsupportedOperationException

    }
}
