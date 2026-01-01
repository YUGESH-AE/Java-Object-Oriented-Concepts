package com.yugesh.dsa.problems.algorithm.slidingWindow.variableWindow;

public class SlidingWindowEasy {

    static void main() {

        int[] min = {2, 3, 1, 2, 4, 3};
        System.out.println(minimumLengthOfSubarray(min, 7));

        String s = "aaabbbaaac";
        System.out.println(lengthOfLongestSubarray(s));

        int[] max = {1, 2, 1, 0, 1, 1, 0};
        System.out.println(maximumLengthOfSubarray(max, 4));
    }

    /**
     * Given an array of positive integers nums and a positive integer target,
     * find the minimum length of a contiguous subarray whose sum is greater than or equal to target.
     *
     * @param a
     * @param target
     * @return
     */
    public static int minimumLengthOfSubarray(int[] a, int target) {
        if (a == null || a.length == 0) return 0;
        int left = 0, min = Integer.MAX_VALUE, windowSum = 0;

        for (int right = 0; right < a.length; right++) {
            windowSum += a[right];

            while (windowSum >= target) {
                min = Math.min(min, (right - left) + 1);
                windowSum -= a[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;


    }

    /**
     * Given a string s,
     * find the length of the longest substring that contains only one unique character.
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubarray(String s) {
        int left = 0, count = 0, max = Integer.MIN_VALUE;

        char[] c = s.toCharArray();
        for (int right = 0; right < s.length(); right++) {
            if (c[left] == c[right]) {
                count++;
                max = Math.max(max, count);
            } else {
                left = right;
                count = 1;
            }
        }
        return max;
    }

    public static int maximumLengthOfSubarray(int[] a, int target) {
        int value = -1;
        if (a == null || a.length == 0) return value;

        int left = 0, windowSum = 0, max = Integer.MIN_VALUE;

        for (int right = 0; right < a.length; right++) {
            windowSum += a[right];
            while (windowSum > target) {
                windowSum -= a[left];
                left++;
            }

            max = Math.max(max, (right - left) + 1);
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
