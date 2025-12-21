package com.yugesh.dsa.problems.algorithm.binarySearch;

public class UpperBound {
    static void main() {

    }

    public static int upper(int[] a, int k) {
        int left = 0, right = a.length - 1;
        int num = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return num;
    }
}
