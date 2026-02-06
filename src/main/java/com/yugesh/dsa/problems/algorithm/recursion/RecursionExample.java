package com.yugesh.dsa.problems.algorithm.recursion;

public class RecursionExample {

    public static void main(String[] args) {
        sumOfNaturalNumbers(10, 0);
    }

    public static void sumOfNaturalNumbers(int i,int sum){

        if(i<1){
            System.out.println(sum);
        }
        sumOfNaturalNumbers(i-1, sum+i);
    }
}
