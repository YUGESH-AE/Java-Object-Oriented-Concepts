package com.yugesh.dsa.problems.algorithm._1_twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoPointerEasy {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 6, 8, 9};
        int targetArray = 10;
        System.out.println(sumExists(array, targetArray));

        int[] a = {1, 1, 2, 2, 3};
        int target = 6;
        System.out.println(pairSum(a, target));
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(reverseArray(a)));

        int[] arr = {4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squareOfSortedArray(arr)));
        int[] arr2 = {1, 0, 2};
        System.out.println(Arrays.toString(moveZeros(arr2)));
    }

    /**
     * You are given a sorted array of integers and a target sum.
     * Return true if there exists a pair whose sum equals the target,
     * otherwise return false.
     *
     * @param a
     * @param target
     * @return
     */
    public static boolean sumExists(int[] a, int target) {
        if (a == null || a.length == 0) {
            return false;
        }

        int left = 0, right = a.length - 1;

        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * Find all unique pairs
     * You are given a sorted array (may contain duplicates) and a target.
     * Return all unique pairs whose sum equals the target.
     *
     * @param a
     * @param target
     * @return
     */
    public static List<List<Integer>> pairSum(int[] a, int target) {

        if (a == null || a.length == 0)
            return Collections.emptyList();

        List<List<Integer>> outerList = new ArrayList<>();
        int left = 0, right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                List<Integer> innerList = new ArrayList<>();
                int leftValue = a[left];
                int rightValue = a[right];
                innerList.add(a[left]);
                innerList.add(a[right]);
                outerList.add(innerList);
                while (a[left] == leftValue && left < right)
                    left++;
                while (a[right] == rightValue && left < right)
                    right--;

            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return outerList;
    }

    /**
     * Remove Duplicates from Sorted Array (in-place)
     * Problem statement
     * You are given a sorted array of integers.
     * Remove the duplicates in-place such that each unique element appears only once.
     * Return the new length of the array.
     *
     * @param a
     * @return
     */
    public static int removeDuplicates(int[] a) {
        int slow = 0;
        for (int fast = 0; fast < a.length; fast++) {
            if (a[slow] != a[fast]) {
                slow++;
                //here we are counting only the length so swapping is
                //unnecessary hence commenting
//                int temp = a[slow];
                a[slow] = a[fast];
//                a[fast] = temp;
            }
        }
        return slow + 1;
    }

    /**
     * Problem: Reverse an Array (in place)
     * Problem statement
     * You are given an array of integers.
     * Reverse the array in place.
     * No extra array.
     * Only constant extra space.
     *
     * @param a
     * @return
     */
    public static int[] reverseArray(int[] a) {
        if (a == null || a.length == 0)
            return new int[1];

        int left = 0, right = a.length - 1;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return a;
    }

    /**
     * Problem: Valid Palindrome
     * Problem statement
     * Given a string s, determine if it is a palindrome,
     * considering only alphanumeric characters and ignoring case.
     * Return true if it is a palindrome, otherwise false.
     *
     * @param s
     * @return
     */
    public static boolean palindrome(String s) {
        if (s == null)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Problem: Squares of a Sorted Array
     * Problem statement
     * You are given a sorted array of integers (may include negatives).
     * Return a new array containing the squares of each number,
     * sorted in non-decreasing order.
     *
     * @param a
     * @return
     */
    public static int[] squareOfSortedArray(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];

        int left = 0, right = a.length - 1, k = a.length - 1;
        int[] result = new int[a.length];

        while (left <= right) {
            int leftSq = a[left] * a[left];
            int rightSq = a[right] * a[right];

            if (leftSq > rightSq) {
                result[k--] = leftSq;
                left++;
            } else {
                result[k--] = rightSq;
                right--;
            }
        }
        return result;
    }

    /**
     * Problem: Move Zeros to the End (in place)
     * Problem statement
     * Given an integer array a,
     * move all 0s to the end of the array in place,
     * while maintaining the relative order of non-zero elements.
     *
     * @param a
     * @return
     */
    public static int[] moveZeros(int[] a) {
        int slow = 0;

        for (int fast = 0; fast < a.length; fast++) {
            if (a[fast] != 0) {
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
                slow++;
            }
        }
        return a;
    }
}