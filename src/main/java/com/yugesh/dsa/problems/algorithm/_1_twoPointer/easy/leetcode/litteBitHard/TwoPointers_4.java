package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode.litteBitHard;

import java.util.*;

public class TwoPointers_4 {
    static void main() {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        System.out.println(Arrays.toString(mergeSortedArrays(nums1, m, nums2, n)));

        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(mergeStringAlternatively(word1, word2));


    }

    /**
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — reverse merge (write from back)
     * Problem statement
     * You are given two sorted integer arrays:
     * nums1 of size m + n, where the first m elements are valid and the last n are empty (0s)
     * nums2 of size n
     * Merge nums2 into nums1 in-place so that nums1 becomes a single sorted array.
     *
     * @param num1
     * @param m
     * @param num2
     * @param n
     * @return
     */
    public static int[] mergeSortedArrays(int[] num1, int m, int[] num2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (num1[i] > num2[j]) {
                num1[k] = num1[i];
                k--;
                i--;
            } else {
                num1[k] = num2[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            num1[k] = num2[j];
            k--;
            j--;
        }
        return num1;
    }

    public static String mergeStringAlternatively(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                stringBuilder.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                stringBuilder.append(word2.charAt(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Pattern: Two Pointer (after sorting)
     * Key constraint: Result must contain unique elements only
     * Given two arrays, return all values that appear in both, without duplicates.
     * Order does not matter.
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int[] intersectionOfArrays(int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : num1) {
            set.add(i);
        }

        for (int i : num2) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        int[] r = new int[result.size()];
        int i = 0;
        for (int num : result) {
            r[i++] = num;
        }
        return r;
    }

    /**
     * Intersection of Two Arrays II
     * Pattern: Two Pointer (after sorting)
     * Key difference: Duplicates ARE allowed
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int[] intersectionOfArrays2(int[] num1, int[] num2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : num1) {
            map.compute(num, (k, v) -> v == 0 ? 1 : v + 1);
        }
        for (int num : num2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] output = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            output[i++] = num;
        }
        return output;
    }

     /**
     * Assign Cookies
     * You are given two integer arrays:
     * g where g[i] is the greed factor of the i-th child
     * s where s[j] is the size of the j-th cookie
     * Each child can be content with at most one cookie, and each cookie can be given to at most one child.
     *
     * A child i will be content if they are given a cookie j such that:
     * s[j] >= g[i]
     * Input:  g = [1,2,3], s = [1,1]
     * Output: 1
     * Input:  g = [1,2], s = [1,2,3]
     * Output: 2
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;  // move to next child
                j++;  // move to next cookie
            } else {
                j++;  // cookie too small, discard it
            }
        }

        return count;
    }

    public static String reverseString(String s){
        String[]w=s.split(" ");
        StringBuilder sb=new StringBuilder();
       for(int i=0;i<w.length;i++){
           sb.append(reverse(w[i]));
           if(i<w.length-1){
               sb.append(" ");
           }
       }
        return sb.toString();
    }

    public static String reverse(String s){
        int i=0,j=s.length()-1;
        char[]c=s.toCharArray();
        while (i<j){
            char temp=c[i];
            c[i]=c[j];
            c[j]=temp;
            i++;
            j--;
        }
        return new String(c);
    }

    /**
     * Check If a String Is a Palindrome (alphanumeric)
     * This is Valid Palindrome (LeetCode 125).
     * Problem (very precise)
     * Given a string s:
     * Consider only alphanumeric characters
     * letters: a–z, A–Z
     * digits: 0–9
     * Ignore case
     * Check whether the resulting string is a palindrome
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare characters
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
