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
    }

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
}
