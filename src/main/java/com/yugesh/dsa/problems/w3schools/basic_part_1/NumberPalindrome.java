package com.yugesh.dsa.problems.w3schools.basic_part_1;

public class NumberPalindrome {
    static void main() {

        palindrome(1211);

    }

    public static void palindrome(int num){
        int original=num;
        int reversed=0;

        while (num!=0){
            int div=num%10;
            reversed=reversed*10+div;
            num=num/10;
        }
        System.out.println(original==reversed?"palindrome":"not a palindrome");
    }
}
