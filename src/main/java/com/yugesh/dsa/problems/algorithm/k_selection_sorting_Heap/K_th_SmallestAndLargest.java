package com.yugesh.dsa.problems.algorithm.k_selection_sorting_Heap;

import java.util.Arrays;

public class K_th_SmallestAndLargest {

    static void main() {

        int[] a = {1, 4, 17, 7, 25, 3, 100};
        k_thSmallest(a, 2);
        k_thLargest(a, 2);
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kth_smallest(arr, 3));
    }

    public static void k_thSmallest(int[] a, int k) {
        Arrays.sort(a);
        System.out.println("sorted:" + Arrays.toString(a));
        k = k - 1;
        for (int i = 0; i < a.length; i++) {
            if (k == 0) {
                System.out.println(a[i]);
                return;
            }
            k--;
        }

    }

    public static void k_thLargest(int[] a, int k) {
        Arrays.sort(a);
        System.out.println("sorted:" + Arrays.toString(a));
        k = k - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (k == 0) {
                System.out.println(a[i]);
            }
            k--;
        }
    }

    public static int kth_smallest(int[] a, int k) {

        Arrays.sort(a);

        return a[k - 1];
    }
}
