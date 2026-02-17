package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 10};
        System.out.println(Arrays.toString(getGreater(a)));
    }

    public static int[] getGreater(int[] a) {
        int[] x = new int[a.length];
        Arrays.fill(x, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {
            //> for next greater element
            //< for next smaller element
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                int top = stack.pop();
                x[top] = a[i];
            }
            stack.push(i);
        }


        return x;
    }
}
