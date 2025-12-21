package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOfStrings_2 {
    static void main() {

        String s = "I am learning streams api in java";
        stringWithVowels(s);

        String m = "Mississippi";
        System.out.println(occurrenceOfCharacters(m));

        String h = "Hello World";
        System.out.println(firstNonRepeatingCharacter(h));

        System.out.println(firstRepeatedCharacter(h));
    }

    /**
     * Given a sentence, find the words with a specified number of vowels
     *
     * @param s
     */
    public static void stringWithVowels(String s) {

        Arrays.stream(s.split(" "))
                .filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2)
                .forEach(System.out::println);
    }

    /**
     * Given a word, find the occurrence of each character
     *
     * @param s
     * @return
     */
    public static Map<Character, Long> occurrenceOfCharacters(String s) {

        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
    }

    /**
     * Given a string, find the first non-repeated character
     *
     * @param s
     * @return
     */
    public static char firstNonRepeatingCharacter(String s) {

        return Arrays.stream(s.split(" "))
                .map(String::chars)
                .flatMap(s2 -> s2.mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(n -> n.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    /**
     * Given a string, find the first repeated character
     *
     * @param s
     * @return
     */
    public static char firstRepeatedCharacter(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .filter(n -> n.getValue() >= 2)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
