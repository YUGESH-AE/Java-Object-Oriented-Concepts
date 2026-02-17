package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackSpaceStringCompare {

    public static void main(String[] args) {

        String s1 = "ab#c";
        String s2 = "ad#c";

        String newS1 = backSpace(s1);
        String newS2 = backSpace(s2);
        if (newS1.equals(newS2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static String backSpace(String s1) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s1.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb1.append(stack.pop());
        }
        return sb1.reverse().toString();
    }

}
