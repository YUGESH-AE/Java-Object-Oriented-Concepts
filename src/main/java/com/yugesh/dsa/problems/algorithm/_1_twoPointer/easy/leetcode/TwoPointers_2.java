package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers_2 {

    public static void main(String[] args) {

        int[] moveZero = {1, 2, 0, 3, 12};
        System.out.println(Arrays.toString(moveZerosToEnd(moveZero)));

        int[] removeElement = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(removeElement, 2));

        int[] removeDuplicates = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(removeDuplicates));

        int[] removeDuplicates2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates_2(removeDuplicates2));

        String s = "ab#c", t = "ad#c";
        System.out.println(backSpaceStringCompare(s, t));

        String reverseWords = "Let's take LeetCode contest";
        System.out.println(reverseWordsInString(reverseWords));

        String palindrome_2 = "abca";
        System.out.println(isPalindromeWithOneDeletion(palindrome_2));

        String name = "alex", typed = "aaleex";
        System.out.println(longTypedName(name, typed));

        int[] num5 = {1, 2, 3, 0, 0, 0};
        int[] num6 = {2, 5, 6};
        System.out.println(Arrays.toString(merge(num5, 3, num6, 3)));

        int[] greedChildren = {1, 2};
        int[] size = {1, 2, 3};
        System.out.println(assignCookie(greedChildren, size));

        String ss = "axc", tt = "ahbgdc";
        System.out.println(isSubsequence(ss, tt));

        int[] num8 = {4, 9, 5};
        int[] num9 = {9, 4, 9, 8, 4};
        System.out.println(intersectionOfTwoArrays(num8, num9));
    }

    /**
     * Problem 6 — Move Zeroes
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction (slow–fast)
     * Problem statement
     * Given an integer array nums, move all 0s to the end of the array in-place,
     * while maintaining the relative order of the non-zero elements.
     * You must do this without making a copy of the array.
     *
     * @param a
     * @return
     */
    public static int[] moveZerosToEnd(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];

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

    /**
     * Problem 7 — Remove Element
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction (slow–fast)
     * Problem statement
     * Given an integer array nums and an integer val, remove all occurrences of val
     * in-place.
     * The relative order of the remaining elements may be changed
     * Return the number of elements not equal to val
     * The first k elements of nums should contain the result
     * Anything beyond k doesn’t matter
     *
     * @param a
     * @param element
     * @return
     */
    public static int removeElement(int[] a, int element) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 0; fast < a.length; fast++) {
            if (a[fast] != element) {
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
                slow++;
            }
        }
        System.out.println(Arrays.toString(a));
        return slow;
    }

    /**
     * Problem 8 — Remove Duplicates from Sorted Array
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction (slow–fast, sorted array)
     * Problem statement
     * Given an integer array nums sorted in non-decreasing order, remove the
     * duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same
     * Return the number of unique elements
     * The first k elements of nums should contain the final result
     * Anything beyond k does not matter
     *
     * @param a
     * @return
     */
    public static int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int slow = 0;
        int count=1;
        for (int fast = 1; fast < a.length; fast++) {
            if (a[slow] != a[fast]) {
                slow++;
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        return slow + 1;
    }

    /**
     * Problem 9 — Remove Duplicates from Sorted Array II
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction, frequency-limited
     * Problem statement
     * Given an integer array nums sorted in non-decreasing order, remove duplicates
     * in-place such that each unique element appears at most twice.
     * Relative order must be preserved
     * Return the number of elements after removal
     * First k elements of nums must contain the result
     * Anything beyond k does not matter
     *
     * @param a
     * @return
     */
    public static int removeDuplicates_2(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int slow = 2;
        for (int fast = 2; fast < a.length; fast++) {
            if (a[slow - 2] != a[fast]) {
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
                slow++;
            }
        }
        System.out.println(Arrays.toString(a));
        return slow;
    }

    /**
     * Problem 10 — Backspace String Compare
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — reverse traversal with skip counters
     * Problem statement
     * Given two strings s and t, return true if they are equal after processing
     * backspaces.
     * '#' means delete the previous character
     * Deleting when nothing exists does nothing
     *
     * @param s
     * @param t
     * @return
     */
    // need to learn after
    public static boolean backSpaceStringCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0, skipT = 0;

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
                if (s.charAt(i) != t.charAt(j))
                    return false;
            } else {
                // One string ended before the other
                if (i >= 0 || j >= 0)
                    return false;
            }

            i--;
            j--;
        }

        return true;
    }

    /**
     * Problem 11 — Reverse Words in a String III
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — in-place reversal inside segments
     * Problem statement
     * Given a string s, reverse the characters of each word while preserving:
     * Word order
     * Spaces
     * Overall string structure
     * A word is a sequence of non-space characters.
     *
     * @param word
     * @return
     */

    public static String reverseWordsInString(String word) {
        int boundry = 0, left = 0, right = 0;
        char[] c = word.toCharArray();
        while (boundry < word.length()) {
            while (boundry < word.length() && !Character.isSpaceChar(c[boundry])) {
                boundry++;
            }
            right = boundry - 1;
            while (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            boundry++;
            left = boundry;
        }
        return String.valueOf(c);
    }

    /**
     * Problem 12 — Valid Palindrome II
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends with one allowed deletion
     * Problem statement
     * Given a string s, return true if the string can become a palindrome after
     * deleting at most one character.
     * You may delete at most one character
     * String contains lowercase letters only
     *
     * @param s
     * @return
     */
    // dono how this works
    public static boolean isPalindromeWithOneDeletion(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return palindromeDeletion(s, left + 1, right) ||
                        palindromeDeletion(s, left, right - 1);
            }
        }
        return true;
    }

    private static boolean palindromeDeletion(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Problem 13 — Long Pressed Name
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction, character run comparison
     * Problem statement
     * Your friend is typing their name, but some characters might be long-pressed
     * (typed multiple times).
     * Given two strings:
     * name (intended)
     * typed (what actually appeared)
     * Return true if typed could be a long-pressed version of name.
     *
     * @param name
     * @param typed
     * @return
     */
    public static boolean longTypedName(String name, String typed) {

        int i = 0, j = 0;

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }

    /**
     * Problem 14 — Merge Sorted Array
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — reverse merge (write from back)
     * Problem statement
     * You are given two sorted integer arrays:
     * nums1 of size m + n, where the first m elements are valid and the last n are
     * empty (0s)
     * nums2 of size n
     * Merge nums2 into nums1 in-place so that nums1 becomes a single sorted array.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // last valid index in nums1
        int j = n - 1; // last index in nums2
        int k = m + n - 1; // write position

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }

    /**
     * Problem 15 — Assign Cookies
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — greedy + sorted arrays
     * Problem statement
     * You are given:
     * g → children’s greed factors
     * s → cookie sizes
     * Each child can get at most one cookie, and a cookie can satisfy a child only
     * if:
     * cookie size ≥ child greed
     *
     * @param g
     * @param s
     * @return
     */
    public static int assignCookie(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++; // one child satisfied
                i++;
                j++;
            } else {
                j++; // cookie too small, discard
            }
        }
        return count;
    }

    /**
     * Problem 16 — Is Subsequence
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction (sequence matching)
     * Problem statement
     * Given two strings s and t, return true if s is a subsequence of t.
     * A subsequence means:
     * You can delete characters from t
     * Without changing the relative order
     * Characters in s must appear in order inside t
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return i == s.length();
    }

    /**
     * Problem 17 — Intersection of Two Arrays
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — sorted arrays, unique result
     * Problem statement
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection.
     * Rules:
     * Each element in the result must be unique
     * Order of result does not matter
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static List<Integer> intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // avoid duplicates in result
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    /**
     * Problem 18 — Intersection of Two Arrays II
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — sorted arrays, duplicates allowed
     * Problem statement
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection.
     * Rules:
     * Each element in the result should appear as many times as it appears in both
     * arrays
     * Order of result does not matter
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // convert list to array
        int[] res = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            res[k] = result.get(k);
        }
        return res;
    }

}
