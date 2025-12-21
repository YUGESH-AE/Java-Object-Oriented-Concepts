package com.yugesh.dsa.problems.algorithm.binarySearch;

public class FirstOccurrence {

    static void main() {

        int[] a = {1, 2, 2, 2, 3, 4, 5};
        int k = 2;
        System.out.println(occurrence(a, k));
    }

    public static int occurrence(int[] a, int k) {

        int left = 0, right = a.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == k) {
                ans = mid;
                right = mid - 1;
            } else if (a[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
