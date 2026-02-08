package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode.litteBitHard;

import java.util.Arrays;

public class TwoPointers_3 {

    static void main() {

        int[] container = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater(container));

        int[] removeDuplicates_2 = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates2(removeDuplicates_2));
    }

    /**
     * leetcode
     * Problem recap (in plain language)
     * You are given heights of vertical lines
     * Pick two lines
     * Water =min(height[left], height[right]) × (right - left)
     * Maximize the water
     *
     * @param heights
     * @return
     */
    public static int containerWithMostWater(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(heights[left], heights[right]);
            int area = width * minHeight;
            max = Math.max(max, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static int removeDuplicates2(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int slow = 0;
        int count = 1; // count of current element

        for (int fast = 1; fast < a.length; fast++) {

            if (a[fast] == a[slow]) {
                if (count < 2) {
                    slow++;
                    int temp = a[slow];
                    a[slow] = a[fast];
                    a[fast] = temp;
                }
                count++;
            } else {
                // new number
                slow++;
                a[slow] = a[fast];
                count = 1;
            }
        }

        System.out.println(Arrays.toString(a));
        return slow + 1;
    }

    /**
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — reverse traversal with skip counters
     * Problem statement
     * Given two strings s and t, return true if they are equal after processing backspaces.
     * '#' means delete the previous character
     * Deleting when nothing exists does nothing
     * Input:  s = "ab#c", t = "ad#c"
     * Output: true
     * Explanation: both become "ac"
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            // Find next valid character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find next valid character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                // one string ended before the other
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }

    /**
     * Problem 12 — Valid Palindrome II
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends with one allowed deletion
     * <p>
     * Problem statement
     * Given a string s, return true if the string can become a palindrome after deleting at most one character.
     * You may delete at most one character
     * String contains lowercase letters only
     * Input:  "aba"
     * Output: true
     * <p>
     * Input:  "abca"
     * Output: true
     * Explanation: delete 'c'
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome2(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String w, int left, int right) {

        while (left < right) {
            if (w.charAt(left) != w.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }


}
