package com.yugesh.dsa.problems.algorithm.binarySearch.easy;

public class BinarySearch_3 {

    static void main() {

        int[] rotated = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(minimumElementInRotatedSorted(rotated));

        int rotatedTarget = 0;
        System.out.println(searchInRotatedSortedIndex(rotated, rotatedTarget));


    }

    /**
     * Find Minimum in a Rotated Sorted Array
     *
     * @param a
     * @return
     */
    public static int minimumElementInRotatedSorted(int[] a) {
        int value = -1;
        if (a == null || a.length == 0) {
            return value;
        }
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return a[left];
    }

    public static int searchInRotatedSortedIndex(int[] a, int target) {
        int value = -1;
        if (a == null || a.length == 0) {
            return value;
        }

        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                value = mid;
                break;
            } else if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return value;
    }
}
