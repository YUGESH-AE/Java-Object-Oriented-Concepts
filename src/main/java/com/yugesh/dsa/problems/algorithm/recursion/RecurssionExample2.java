package com.yugesh.dsa.problems.algorithm.recursion;

import java.util.Arrays;

public class RecurssionExample2 {


      public static void main(String[] args) {

        int[]a={1,2,3,4,5,6,7,8};
        reverseArray(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        String s="madam";
        System.out.println(isPalindrome(s.toCharArray(),0,s.length()-1,false));
        System.out.println(isPalindrome2(s,0));
    }


     public static void reverseArray(int[]a, int left, int right){
        if(!(left<right)){
            return;
        }
        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;
        reverseArray(a,++left,--right);
    }

    public static boolean isPalindrome(char[]c,int start,int end,boolean result){
         if(!(start<end)){
             return true;
         }
        if(c[start]!=c[end]){
            return false;
        }
        result=true;

         return isPalindrome(c,++start,--end,result);
    }

    public static boolean isPalindrome2(String s,int i){
        int n=s.length();
        if(i>=n/2)return true;

        if(s.charAt(i)!=s.charAt(n-i-1)){
            return false;
        }
        return isPalindrome2(s,++i);
    }
}
