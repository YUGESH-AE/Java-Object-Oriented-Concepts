package com.yugesh.dsa.problems.algorithm.slidingWindow.variableWindow;

public class MaximumLengthOfSubArrayWithTarget {

    static void main() {

        int[] a = {2, 1, 5, 1, 3, 2};
        int target = 7;

        System.out.println(count(a, target));
    }

    public static int count(int[] a, int target) {
        if (a == null || a.length == 0) return 0;
        int left = 0;
        int windowSum = 0, maxLength = Integer.MIN_VALUE;

        for (int right = 0; right < a.length; right++) {
            windowSum += a[right];

            while (windowSum > target) {
                windowSum -= a[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;

    }
}
