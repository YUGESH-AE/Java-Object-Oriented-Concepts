package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap;

public class ThirdLargest {

    static void main() {

        int[] c = {10, 4, 7, 25, 1, 100};
        System.out.println(thirdLargest(c));
    }

    public static int thirdLargest(int[] c) {
        int max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE, third_max = Integer.MIN_VALUE;

        for (int i : c) {
            if (i > max) {
                third_max = sec_max;
                sec_max = max;
                max = i;
            } else if (i > sec_max && i < max) {
                third_max = sec_max;
                sec_max = i;
            } else if (i > third_max && i < sec_max) {
                third_max = i;
            }
        }
        return third_max;
    }
}
