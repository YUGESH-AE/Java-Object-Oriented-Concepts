package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;

public class StreamOfStrings_3 {

    static void main() {

        String[] s = {"abc", "123", "456", "xyz"};
        System.out.println(Arrays.toString(containsOnlyInteger(s)));
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
}
