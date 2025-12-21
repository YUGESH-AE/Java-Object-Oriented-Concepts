package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {

        String s = "abbaca";
        System.out.println(removeAdjacent(s));
    }

    public static String removeAdjacent(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (c == top) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
