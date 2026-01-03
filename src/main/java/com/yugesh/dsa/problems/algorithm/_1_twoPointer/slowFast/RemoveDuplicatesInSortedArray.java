package com.yugesh.dsa.problems.algorithm._1_twoPointer.slowFast;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {
    static void main() {

        int[] a = {1, 1, 2, 2, 2, 3, 4, 4};
        System.out.println(removeDuplicates(a));

    }

    public static int removeDuplicates(int[] a) {

        int slow = 0;
        for (int fast = 1; fast < a.length; fast++) {
            if (a[slow] != a[fast]) {
                slow++;
                a[slow] = a[fast];
            }
        }
        System.out.println("After Moving duplicates:" + Arrays.toString(a));
        return slow + 1;
    }
}
