package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode;

import java.util.Arrays;

public class TwoPointers_2 {

     public static void main(String[] args) {

        int[]moveZero={1,2,0,3,12};
        System.out.println(Arrays.toString(moveZerosToEnd(moveZero)));

        int[]removeElement={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(removeElement,2));

        int[]removeDuplicates={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(removeDuplicates));

        int[]removeDuplicates2={0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates_2(removeDuplicates2));

        String s="ab#c",t="ad#c";
        System.out.println(backSpaceStringCompare(s,t));
    }

    /**
     * Problem 6 — Move Zeroes
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction (slow–fast)
     * Problem statement
     * Given an integer array nums, move all 0s to the end of the array in-place, while maintaining the relative order of the non-zero elements.
     * You must do this without making a copy of the array.
     * @param a
     * @return
     */
    public static int[] moveZerosToEnd(int[]a){
        if(a==null||a.length==0)
            return new int[0];

        int slow=0;

        for(int fast=0;fast<a.length;fast++){
            if(a[fast]!=0){
                int temp=a[slow];
                a[slow]=a[fast];
                a[fast]=temp;
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
     * Given an integer array nums and an integer val, remove all occurrences of val in-place.
     * The relative order of the remaining elements may be changed
     * Return the number of elements not equal to val
     * The first k elements of nums should contain the result
     * Anything beyond k doesn’t matter
     * @param a
     * @param element
     * @return
     */
    public static int removeElement(int[]a,int element){
        if(a==null||a.length==0){
            return 0;
        }

        int slow=0;
        for(int fast=0;fast<a.length;fast++){
            if(a[fast]!=element){
                int temp=a[slow];
                a[slow]=a[fast];
                a[fast]=temp;
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
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same
     * Return the number of unique elements
     * The first k elements of nums should contain the final result
     * Anything beyond k does not matter
     * @param a
     * @return
     */
    public static int removeDuplicates(int[]a){
        if(a==null||a.length==0){
            return 0;
        }
        int slow=0;
        for(int fast=1;fast<a.length;fast++){
            if(a[slow]!=a[fast]){
                slow++;
                int temp=a[slow];
                a[slow]=a[fast];
                a[fast]=temp;
            }
        }
        System.out.println(Arrays.toString(a));
        return slow+1;
    }

    /**
     * Problem 9 — Remove Duplicates from Sorted Array II
     * Source: LeetCode (Easy)
     * Pattern: Two Pointer — same direction, frequency-limited
     * Problem statement
     * Given an integer array nums sorted in non-decreasing order, remove duplicates in-place such that each unique element appears at most twice.
     * Relative order must be preserved
     * Return the number of elements after removal
     * First k elements of nums must contain the result
     * Anything beyond k does not matter
     * @param a
     * @return
     */
    public static int removeDuplicates_2(int[]a){
        if(a==null||a.length==0){
            return 0;
        }
        int slow=2;
        for(int fast=2;fast<a.length;fast++){
            if(a[slow-2]!=a[fast]){
                int temp=a[slow];
                a[slow]=a[fast];
                a[fast]=temp;
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
     * Given two strings s and t, return true if they are equal after processing backspaces.
     * '#' means delete the previous character
     * Deleting when nothing exists does nothing
     * @param s1
     * @param s2
     * @return
     */
    public static boolean backSpaceStringCompare(String s1,String s2){
        char[]c1=s1.toCharArray();
        char[]c2=s2.toCharArray();
        StringBuilder sb1=new StringBuilder();
        for(int last=c1.length-1;last>=0;last--){
            if(c1[last]=='#'){
                last=last-2;
            }
            sb1.append(c1[last]);
        }
        StringBuilder sb2=new StringBuilder();
        for(int last=c2.length-1;last>=0;last--){
            if(c2[last]=='#'){
                last=last-2;
            }
            sb2.append(c2[last]);
        }
       return sb1.compareTo(sb2) == 0;
    }
}
