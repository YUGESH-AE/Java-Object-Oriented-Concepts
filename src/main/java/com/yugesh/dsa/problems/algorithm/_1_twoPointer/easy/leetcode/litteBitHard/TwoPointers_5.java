package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode.litteBitHard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TwoPointers_5 {

      public static void main(String[] args) {

        int[]a={5, 20, 3, 2, 5, 80};
        int k=78;
        System.out.println(pairWithDifference(a,k));

        int[]aa={1,2,3,4,5,6,7,8};
        System.out.println(removeEven(aa));

        int[]b={1,0,0,1,1,1,0,1,1};
        System.out.println(Arrays.toString(moveZerosToFront(b)));

        int[]oddEven={12, 34, 45, 9, 8, 90, 3};
        System.out.println(Arrays.toString(segregateEvenOdd(oddEven)));

        String s="leEeetcode";
        System.out.println(greatString(s));

        String s1 = "abcde";
        String t1 = "ahbgdc";
        System.out.println(isSequence(s1,t1));

        String[]words = {"a", "bb", "acd", "ace"};
        System.out.println(matchingSubsequence(s1,words));



    }


    /**
     * Pair with Given Difference
     * Given an array of integers arr[] of size n and an integer k, determine whether there exists a pair of elements in the array such that:
     * |arr[i] - arr[j]| = k
     * where i ≠ j.
     * Return true if such a pair exists, otherwise return false.
     * Input:  arr = [5, 20, 3, 2, 5, 80], k = 78
     * Output: true
     * Explanation: 80 - 2 = 78
     * @param a
     * @param k
     * @return
     */
    public static boolean pairWithDifference(int[] a, int k) {
        Arrays.sort(a);

        int i = 0, j = 1;

        while (i < a.length && j < a.length) {
            if (i == j) {
                j++;
                continue;
            }

            int diff = a[j] - a[i];

            if (diff == k) {
                return true;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }


    /**
     * Remove Even Numbers from Array (In-Place)
     * Given an integer array arr[], remove all even numbers from the array in-place.
     * Return the number of elements remaining after removal.
     * The first k elements of the array should contain only the odd numbers, and the rest of the array can contain anything.
     * Input:  arr = [1, 2, 3, 4, 5, 6]
     * Output: 3
     *
     * Array becomes: [1, 3, 5, _, _, _]
     * @param arr
     * @return
     */
    public static int removeEven(int[] arr) {
        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] % 2 != 0) {   // odd number
                arr[slow++] = arr[fast];
            }
        }
        return slow;  // number of odd elements
    }


    /**
     * Segregate 0s and 1s
     * Given an array containing only 0s and 1s, rearrange the array in-place so that:
     * All 0s appear on the left
     * All 1s appear on the right
     * Order does not matter.
     *
     * Input:  [0,1,0,1,1,0]
     * Output: [0,0,0,1,1,1]
     *
     * Segregate 0s and 1s
     *
     * Given an array containing only 0s and 1s, rearrange the array in-place so that:
     *
     * All 0s appear on the left
     *
     * All 1s appear on the right
     *
     * Order does not matter.
     * @param a
     * @return
     */
    public static int[] moveZerosToFront(int[]a){
        int left=0,right=a.length-1;

        while (left<right){
            if(a[left]==0){
                left++;
            } else if (a[right]==1) {
                right--;
            }else {
                int temp=a[left];
                a[left]=a[right];
                a[right]=temp;
                left++;
                right--;
            }
        }
        return a;
    }

    /**
     *Segregate Even and Odd Numbers (In-Place)
     *
     * Given an integer array arr[], rearrange it so that:
     *
     * All even numbers appear on the left
     *
     * All odd numbers appear on the right
     *
     * Order does not matter.
     *
     * Input:  [12, 34, 45, 9, 8, 90, 3]
     * Output: [12, 34, 90, 8, 9, 45, 3]
     * @param arr
     * @return
     */
    public static int[] segregateEvenOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] % 2 == 0) {
                left++;
            }
            else if (arr[right] % 2 != 0) {
                right--;
            }
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return arr;
    }

    /**
     * Make The String Great
     *
     * Given a string s of lowercase and uppercase letters, repeatedly remove adjacent characters where:
     * s[i] and s[i+1] are the same letter
     * BUT in different cases
     * Example:
     *
     * 'a' and 'A' → remove
     *
     * 'b' and 'B' → remove
     *
     * 'a' and 'b' → keep
     *
     * Return the final string after no more removals can be made.
     *
     * Input:  "leEeetcode"
     * Output: "leetcode"
     *
     * Input:  "abBAcC"
     * Output: ""
     * @param s
     * @return
     */
    public static String greatString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() &&
                    Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static boolean isSequence(String s, String t){
        int i=0,j=0;
        while (i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public static int matchingSubsequence(String s, String[]words){
        int count=0;

        for(String word:words){
            if(isSequence(word,s)){
                count++;
            }
        }
        return count;
    }
}
