package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {

    static void main() {
        String s = "abcd";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        if (s == null) return null;

        Deque<Character> d = new ArrayDeque<>();

        for (char i : s.toCharArray()) {
            d.push(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            sb.append(d.pop());
        }

        return sb.toString();
    }
}
