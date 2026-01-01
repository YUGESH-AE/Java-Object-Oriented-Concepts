package com.yugesh.dsa.problems.algorithm.stack.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stack {

    static void main() {

        String str = "{([]})";
        System.out.println(validParentheses(str));

        String word = "abbaca";
        System.out.println(removeAdjacentDuplicates(word));

        int[] a = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextGreaterElement(a)));

        int[] arr = {3, 1, 2};
        System.out.println(Arrays.toString(nextGreaterCircular(arr)));

        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(nextGreaterElementTemperature(temperature)));
    }

    public static boolean validParentheses(String str) {

        if (str.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                else if (c == '}' && top != '{') return false;
                else if (c == ']' && top != '[') return false;
            }

        }
        return stack.isEmpty();
    }

    public static String removeAdjacentDuplicates(String word) {

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == stack.peek()) {
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
        return sb.reverse().toString();
    }

    public static int[] nextGreaterElement(int[] a) {
        int[] result = new int[a.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                    int top = stack.pop();
                    result[top] = a[i];
                }
                stack.push(i);
            }
        }

        return result;
    }

    public static int[] nextGreaterCircular(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while (!stack.isEmpty() && a[index] > a[stack.peek()]) {
                int top = stack.pop();
                result[top] = a[index];
            }
            if (i < n) {
                stack.push(index);
            }

        }

        return result;
    }

    public static int[] nextGreaterElementTemperature(int[] temperature) {

        int n = temperature.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperature.length; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                    int top = stack.pop();
                    int diff = i - top;
                    result[top] = diff;
                }
                stack.push(i);
            }

        }
        return result;
    }

}
