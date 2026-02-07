package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode;

import java.util.Arrays;

public class TwoPointers_1 {
    static void main() {

        int[]twoSumNo={2, 7, 11, 15};
        int twoSumTarget=9;
        System.out.println(Arrays.toString(twoSum(twoSumNo, twoSumTarget)));

        String palindrome= "A man, a plan, a canal: Panama";
        System.out.println(palindrome(palindrome));

        String reverse="hello";
        System.out.println(Arrays.toString(reverseString(reverse.toCharArray())));

        String reverseVowel="hello";
        System.out.println(reverseVowels(reverseVowel));

        int[]square={-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squareOfSortedArray(square)));
    }

    /**
     * Problem 1 — Two Sum II (Sorted Array)
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends
     * Problem statement (no hints, no solution)
     * You are given a 1-indexed integer array numbers that is sorted in non-decreasing order,
     * and an integer target.
     * Return the 1-based indices of the two numbers such that they add up to target.
     * Exactly one solution exists.
     * @param a
     * @param target
     * @return
     */
    public static int[] twoSum(int[]a,int target){
        if(a==null||a.length==0)
            return  new int[]{0, 0};

        int left=0,right=a.length-1;
        while (left<right){
            int value=a[left]+a[right];
            if(value==target){
                return new int[]{left+1,right+1};
            } else if (value>target) {
                right--;
            }else {
                left++;
            }
        }
        throw new IllegalArgumentException("No solution exists");
    }

    /**
     * Problem 2 — Valid Palindrome
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends (character filtering)
     * Problem statement
     * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * Return true if it is a palindrome, otherwise false.
     * @param s
     * @return
     */
    public static boolean palindrome(String s){
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left=0,right=s.length()-1;
        while (left<right){
            while (left<right&& !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * Problem 3 — Reverse String
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends (in-place)
     * Problem statement
     * You are given a character array char[] s.
     * Reverse the array in-place.
     * You must not allocate extra space
     * Modify the input array directly
     * Return nothing
     * @param c
     * @return
     */
    public static char[] reverseString(char[]c){
       if(c==null||c.length==0){
           throw new IllegalArgumentException("Character length should be greater than 0");
       }

        int left=0,right=c.length-1;
        while (left<right){
           char temp=c[left];
           c[left]=c[right];
           c[right]=temp;
           left++;
           right--;
        }
        return c;
    }

    /**
     * Problem 4 — Reverse Vowels of a String
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends, selective swapping
     * Problem statement
     * Given a string s, reverse only the vowels of the string and return the resulting string.
     * Vowels are: a, e, i, o, u (both lowercase and uppercase)
     * All other characters must stay in the same position
     * @param s
     * @return
     */
    public static String reverseVowels(String s){
        if(s==null||s.isEmpty()){
            return s;
        }
        char[]c=s.toCharArray();
        int left=0,right=c.length-1;
        while (left<right){
            while (left<right&&!isVowel(c[left])){
                left++;
            }
            while (left<right&& !isVowel(c[right])){
                right--;
            }
            char temp=c[left];
            c[left]=c[right];
            c[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(c);
    }

    public static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'
                || c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

    /**
     * Problem 5 — Squares of a Sorted Array
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — opposite ends, write from back
     * Problem statement
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number, also sorted in non-decreasing order.
     * @param a
     * @return
     */
    public static int[] squareOfSortedArray(int[]a){
        if(a==null||a.length==0){
            return new int[0];
        }
        int length=a.length-1;
        int[]result=new int[a.length];
        int left=0,right=length;
        while (left<=right){
            int leftSquare=a[left]*a[left];
            int rightSquare=a[right]*a[right];
            if(leftSquare>rightSquare){
                result[length--]=leftSquare;
                left++;
            }else {
                result[length--]=rightSquare;
                right--;
            }
        }
        return result;
    }

}
