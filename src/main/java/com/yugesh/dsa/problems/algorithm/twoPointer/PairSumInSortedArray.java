package com.yugesh.dsa.problems.algorithm.twoPointer;

public class PairSumInSortedArray {

    static void main() {

        int[] a = {1, 2, 4, 7, 11, 15};
        int target = 15;
        pairSum(a, 15);
    }

    public static void pairSum(int[] a, int target) {

        int left = 0, right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                System.out.println("target reached numbers are:" + a[left] + "," + a[right]);
                return;
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
    }
}
