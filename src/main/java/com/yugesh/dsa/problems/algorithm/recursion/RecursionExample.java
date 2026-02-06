package com.yugesh.dsa.problems.algorithm.recursion;

public class RecursionExample {

    public static void main(String[] args) {
//        sumOfNaturalNumber(3, 0);
//        System.out.println(parametrizedSum(3));
//        System.out.println(factorial(4));
        factorialV2(4,1);
    }

    public static void sumOfNaturalNumber(int i, int sum) {

        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sumOfNaturalNumber(i - 1, sum + i);
    }

    public static int parametrizedSum(int n){
        if(n==0)return 0;

        return n+parametrizedSum(n-1);
    }

    public static int factorial(int n){

        if(n==1)return 1;

        return n*factorial(n-1);
    }
    public static void factorialV2(int i,int fact){
        if(i<1){
            System.out.println(fact);
            return;
        }
        factorialV2(i-1,fact*i);
    }
}
