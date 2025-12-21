package com.yugesh.dsa.problems.streams.streamInterview_2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPis {
    static void main() {

        System.out.println(sumOfDigits(1234));

        System.out.println(frequencyOfEachCharacter("hello world"));
    }

    public static int sumOfDigits(int num) {

        return String.valueOf(num)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static Map<Character, Long> frequencyOfEachCharacter(String s) {

        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

    }
}
