package com.yugesh.dsa.problems.algorithm.slidingWindow.fixedWindow;

public class SumSubArrayTarget {
    static void main() {

        int[] a = {2, 1, 5, 1, 3, 2};
        int k = 3, target = 7;
        System.out.println(count(a, k, target));
    }

    public static int count(int[] a, int k, int target) {
        if (a == null || a.length < k) return 0;

        int windowSum = 0, count = 0;
        for (int i = 0; i < k; i++) {
            windowSum += a[i];
        }
        if (windowSum >= target) {
            count++;
        }
        int left = 0;
        for (int right = k; right < a.length; right++) {
            windowSum += a[right];
            windowSum -= a[left];
            if (windowSum >= target) {
                count++;
            }
            left++;
        }
        return count;
    }
}
