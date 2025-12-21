package com.yugesh.dsa.problems.algorithm.binarySearch;

public class LowerBound {

    static void main() {

        int[] a = {1, 2, 4, 4, 5, 7};
        int k = 4;
        System.out.println(lowerBound(a, k));
    }

    public static int lowerBound(int[] a, int k) {

        int left = 0, right = a.length - 1;
        int num = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] >= k) {
                num = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return num;
    }
}
