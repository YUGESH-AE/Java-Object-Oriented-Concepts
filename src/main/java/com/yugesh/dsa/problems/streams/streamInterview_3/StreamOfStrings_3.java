package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOfStrings_3 {

    static void main() {

        String[] s = {"abc", "123", "456", "xyz"};
        System.out.println(Arrays.toString(containsOnlyInteger(s)));

        List<String> words = List.of("pan", "tap", "pat", "nap", "team", "tree", "meat");

        System.out.println(groupingAnagrams(words));
    }

    /**
     * Given a list of strings, create a list that contains only integers
     *
     * @param s
     * @return
     */
    public static int[] containsOnlyInteger(String[] s) {

        return Arrays.stream(s)
                .filter(x -> x.matches("[0-9]+"))
                .mapToInt(Integer::valueOf)
                .toArray();


    }

    /**
     * Group /Pair anagrams from a list of Strings
     *
     * @param words
     * @return
     */
    public static List<List<String>> groupingAnagrams(List<String> words) {

        return words.stream()
                .collect(
                        Collectors.groupingBy(
                                w -> {
                                    char[] c = w.toCharArray();
                                    Arrays.sort(c);
                                    return new String(c);
                                }
                        )
                ).values().stream().toList();
    }
}
