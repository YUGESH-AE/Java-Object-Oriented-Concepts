package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

public class DistinctExample {


    static void main() {
        Stream.of("ram", "krishna", "shiva", "ram", "seetha", "ravi", "shyam")
                .distinct()
                .forEach(System.out::println);
    }


}
