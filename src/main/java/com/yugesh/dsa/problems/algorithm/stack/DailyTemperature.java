package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {

    public static void main(String[] args) {

        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(temperature(a)));
    }

    public static int[] temperature(int[] a) {
        int[] x = new int[a.length];
        Arrays.fill(x, 0);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                int top = stack.pop();
                int diff = i - top;
                x[top] = diff;
            }
            stack.push(i);
        }
        return x;
    }
}
