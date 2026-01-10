package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap;

import java.util.List;

public class Top_3_largest {
    static void main() {

        int[] a = {10, 4, 7, 25, 1, 100};
        top_3Large(a);
    }

    public static void top_3Large(int[] a) {
        int one = Integer.MIN_VALUE,
                two = Integer.MIN_VALUE,
                three = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > one) {
                three = two;
                two = one;
                one = a[i];
            } else if (a[i] > two && a[i] < one) {
                three = two;
                two = a[i];
            } else if (a[i] > three && a[i] < two) {
                three = a[i];
            }
        }
        System.out.println(List.of(one, two, three));
    }
}
