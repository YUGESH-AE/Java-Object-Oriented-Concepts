package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creates a mutable List (usually ArrayList) from stream elements.
 * Creates an unmodifiable List — meaning it cannot be changed after creation.
 */
public class CollectorsToListExample_1 {

    static void main() {

        //Creates a mutable List (usually ArrayList) from stream elements.
        //You can modify the resulting list (add, remove, etc.)
        List<Integer> mutableList = Stream.of(1, 3, 4, 5, 7, 8, 9)
                .collect(Collectors.toList());

        mutableList.add(2);
        mutableList.add(6);

        System.out.println(mutableList);


        //Safer for APIs that return lists you don’t want callers to modify.
        List<String> unMutableList = Stream.of("A", "B", "C")
                .collect(Collectors.toUnmodifiableList());

//        unMutableList.add("D");
//        unMutableList.add("F");
        System.out.println(unMutableList);
    }
}
