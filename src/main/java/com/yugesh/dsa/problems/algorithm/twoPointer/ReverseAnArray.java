package com.yugesh.dsa.problems.algorithm.twoPointer;

import java.util.Arrays;

public class ReverseAnArray {
    static void main() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("original: " + Arrays.toString(arr));
        reverseArray(arr);

    }

    /**
     * One pointer starts from the left
     * ✔️ One pointer starts from the right
     * ✔️ Both move towards each other (or in same direction depending on problem)
     * <p>
     * Used when:
     * <p>
     * You can compare pairs
     * <p>
     * You want to shrink or expand a range
     * <p>
     * You want to remove or reverse elements
     * <p>
     * You want to check equality (palindrome, numbers)
     *
     * @param a
     */
    public static void reverseArray(int[] a) {

        int left = 0, right = a.length - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        System.out.println("reversed: " + Arrays.toString(a));
    }
}
