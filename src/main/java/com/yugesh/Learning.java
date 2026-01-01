package com.yugesh;


class Learning {

    static void main() {


    }

    public static int maximumLengthOfSubarray(int[] a, int target) {
        if (a == null || a.length == 0) return 0;
        int left = 0, windowSum = 0, max = Integer.MIN_VALUE;

        for (int right = 0; right < a.length; right++) {
            windowSum += a[right];
            while (windowSum > target) {
                windowSum -= a[left];
                left++;
            }
            max = Math.max(max, (right - left) + 1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static int minimumLength(int[] a, int target) {
        if (a == null || a.length == 0) return 0;
        int left = 0, windowSum = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < a.length; right++) {
            windowSum += a[right];
            while (windowSum >= target) {
                min = Math.min(min, (right - left) + 1);
                windowSum -= a[left];
                left++;
            }
        }
        return min;
    }


}