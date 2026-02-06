package com.yugesh.dsa.problems.algorithm.recursion;

public class RecursionBasic {

    public static void main(String[] args) {

        // printNames(0,10);
        // printLinearly(10, 10);
        // printLinearlybacktracking(10, 10);
        printLinearlyv2Backtracking(1, 10);
    }

    public static void printNames(int i, int n) {
        if (i > n) return;
        System.out.println("yugesh");
        printNames(i + 1, n);
    }

    //print linearly from n to 1
    public static void printLinearly(int i, int n) {
        if (i < 1) return;
        System.out.println(i);
        printLinearly(i - 1, n);
    }

    //print linearly from 1 to n
    public static void printLinearlyv2(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        printLinearly(i + 1, n);
    }


    //print linearly from 1 to n by backtracking
    public static void printLinearlybacktracking(int i, int n) {
        if (i < 1) return;
        printLinearlybacktracking(i - 1, n);
        System.out.println(i);
    }

    public static void printLinearlyv2Backtracking(int i, int n) {
        if (i > n) return;
        printLinearlyv2Backtracking(i + 1, n);
        System.out.println(i);
    }
}


