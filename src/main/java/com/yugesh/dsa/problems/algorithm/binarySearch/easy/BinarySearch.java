package com.yugesh.dsa.problems.algorithm.binarySearch.easy;

public class BinarySearch {

    static void main() {

        int[] a = {1, 3, 5, 7, 9};
        int target = 7;
        System.out.println(basicBinarySearch(a, target));

        int[] firstOccurrenceArray = {1, 2, 2, 2, 3, 4};
        int firstOccurrenceTarget = 2;
        System.out.println(firstOccurrence(firstOccurrenceArray, firstOccurrenceTarget));

        int[] lastOccurrenceArray = {1, 2, 2, 2, 3, 4};
        int lastOccurrenceTarget = 2;
        System.out.println(lastOccurrence(lastOccurrenceArray, lastOccurrenceTarget));

        System.out.println(countOccurrence(lastOccurrenceArray, lastOccurrenceTarget));


    }

    /**
     * You are given a sorted array of integers and a target value.
     * Your task is to find the index of the target in the array.
     *
     * @param a
     * @param target
     * @return
     */
    public static int basicBinarySearch(int[] a, int target) {

        if (a == null || a.length == 0) {
            return -1;
        }
        int left = 0, right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * First Occurrence of a Target
     *
     * @param a
     * @param target
     * @return
     */
    public static int firstOccurrence(int[] a, int target) {
        int left = 0, right = a.length - 1;
        int value = -1;
        if (a == null || a.length == 0) {
            return value;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                value = mid;
                right = mid - 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return value;
    }

    /**
     * Last Occurrence of a Target
     *
     * @param a
     * @param target
     * @return
     */
    public static int lastOccurrence(int[] a, int target) {
        int left = 0, right = a.length - 1;
        int value = -1;
        if (a == null || a.length == 0) {
            return value;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                value = mid;
                left = mid + 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return value;
    }

    /**
     * Count Occurrences of a Number
     *
     * @param a
     * @param target
     * @return
     */
    public static int countOccurrence(int[] a, int target) {

        int first = firstOccurrence(a, target);
        int last = lastOccurrence(a, target);

        if (first == -1) {
            return 0;
        }
        int count = last - first + 1;

        return count;
    }


}
