package com.yugesh.dsa.problems.algorithm.twoPointer;

public class StringPalindrome {
    static void main() {
        String s="madam";
        palindrome(s);
    }

    public static void palindrome(String s){
        char[]c=s.toCharArray();
        int left=0,right=c.length-1;
        while (left<right){
            if(c[left]!=c[right]){
                System.out.println(s+" not a palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println(s+" is a palindrome");
    }
}
