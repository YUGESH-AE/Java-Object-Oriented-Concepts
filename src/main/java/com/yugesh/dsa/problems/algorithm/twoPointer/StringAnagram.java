package com.yugesh.dsa.problems.algorithm.twoPointer;

import java.util.Arrays;

public class StringAnagram {

    /**
     * For example, the words “gum” and “mug” are anagrams because they are both three-
     * letter words and have the same letters (g, u, and m).
     * Let's look at some more word pairings that are anagrams: “cork” and “rock” “lamp” and “palm”17 Nov 2023
     */
    static void main() {

        String s1 = "listen";
        String s2 = "silent";
        System.out.println(anagram(s1, s2));
    }

    public static boolean anagram(String s1, String s2) {

        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    public static boolean anagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < s1.length(); i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
