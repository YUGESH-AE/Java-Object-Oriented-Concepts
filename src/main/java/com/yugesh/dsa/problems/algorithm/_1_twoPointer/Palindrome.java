package com.yugesh.dsa.problems.algorithm._1_twoPointer;

public class Palindrome {

    static void main() {

        int[] a = {1, 2, 3, 2, 1};
        System.out.println(palindrome(a));
    }

    public static boolean palindrome(int[] a) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            if (a[start] != a[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
