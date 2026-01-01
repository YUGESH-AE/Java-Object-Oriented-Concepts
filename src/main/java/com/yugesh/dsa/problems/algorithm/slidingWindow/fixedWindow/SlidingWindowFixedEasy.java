package com.yugesh.dsa.problems.algorithm.slidingWindow.fixedWindow;

public class SlidingWindowFixedEasy {

    static void main() {

        int[] a = {2, 1, 5, 1, 3, 2};
        System.out.println(maximumSumOfSubArray(a, 3));

        int[] b = {1, 12, -5, -6, 50, 3};
        System.out.println(maximumAverage(b, 4));

        int[] c = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countOfContiguousSubArray(c, 3, 4));

        String s = "abciiidef";
        System.out.println(maximumVowels(s, 3));
    }

    /**
     * Given an integer array nums and an integer k,
     * find the maximum sum of any contiguous subarray of size k.
     */
    public static int maximumSumOfSubArray(int[] a, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, left = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        maxSum = sum;
        for (int right = k; right < a.length; right++) {
            sum += a[right];
            sum -= a[left];
            left++;
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    /**
     * Given an integer array nums and an integer k, find the maximum average of any contiguous subarray of size k.
     *
     * @param a
     * @param k
     * @return
     */
    public static double maximumAverage(int[] a, int k) {
        int left = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        double maxAvg = sum / k;
        for (int right = k; right < a.length; right++) {
            sum += a[right];
            sum -= a[left];
            left++;

            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }

    /**
     * Given an integer array nums and an integer k, count the number of contiguous subarrays of size k
     * whose sum is greater than or equal to a given value threshold.
     *
     * @param a
     * @param k
     * @param threshold
     * @return
     */
    public static int countOfContiguousSubArray(int[] a, int k, int threshold) {
        int left = 0, sum = 0, count = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        if (sum >= threshold) {
            count++;
        }
        for (int right = k; right < a.length; right++) {
            sum += a[right];
            sum -= a[left];
            left++;
            if (sum >= threshold) {
                count++;
            }
        }
        return count;
    }

    public static int maximumVowels(String s, int k) {

        int left = 0, count = 0;
        int max = Integer.MIN_VALUE;

        char[] c = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (isVowel(c[i])) {
                count++;
            }
        }
        max = count;

        for (int right = k; right < s.length(); right++) {

            if (isVowel(c[right])) {
                count++;
            }
            if (isVowel(c[left])) {
                count--;
            }
            left++;
            max = Math.max(count, max);
        }
        return max;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o'
                || c == 'u' || c == 'A' || c == 'E' ||
                c == 'I' || c == 'O' || c == 'U';
    }
}
