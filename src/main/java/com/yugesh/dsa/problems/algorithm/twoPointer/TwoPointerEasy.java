package com.yugesh.dsa.problems.algorithm.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoPointerEasy {

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 3 };
        int target = 6;

        System.out.println(pairSum(a, target));
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(reverseArray(a)));

        int[] arr = { 4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(squareOfSortedArray(arr)));
        int[] arr2 = { 1, 0, 2 };
        System.out.println(Arrays.toString(moveZeros(arr2)));
    }

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

    public static int removeDuplicates(int[] a) {
        int slow = 0;
        for (int fast = 0; fast < a.length; fast++) {
            if (a[slow] != a[fast]) {
                slow++;
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
            }
        }
        return slow + 1;
    }

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