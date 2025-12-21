package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOfStrings_1 {

    static void main() {

        String s = "I am learning streams api in java";
        System.out.println(highestLength(s));

        String word = "dabcadefg";
        System.out.println(removeDuplicates(word));

        System.out.println(secondHighest(s));

        System.out.println(secondHighestWordLength(s));

        System.out.println(occurrenceOfWord(s));
    }

    /**
     * Given a sentence, find the word that has the highest length
     *
     * @param s
     * @return
     */
    public static String highestLength(String s) {

        return Arrays.stream(s.split(" "))
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).orElse("nothing");
    }

    /**
     * Remove duplicates from the string and return in the same order
     *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();

        s.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .forEach(sb::append);

        return sb.toString();
    }

    /**
     * Find the word that has the second highest length
     *
     * @param s
     * @return
     */
    public static String secondHighest(String s) {

        return Arrays.stream(s.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst().get();

    }

    /**
     * Find the 2nd highest length word in the given sentence
     *
     * @param s
     * @return
     */
    public static int secondHighestWordLength(String s) {

        return Arrays.stream(s.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .map(String::length)
                .findFirst().get();
    }

    /**
     * Given a sentence, find the occurrence of each word
     *
     * @param s
     * @return
     */

    public static Map<String, Long> occurrenceOfWord(String s) {

        return Arrays.stream(s.split(" "))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
    }
}
