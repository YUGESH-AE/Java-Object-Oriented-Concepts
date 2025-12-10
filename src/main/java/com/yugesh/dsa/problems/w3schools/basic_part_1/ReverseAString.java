package com.yugesh.dsa.problems.w3schools.basic_part_1;

public class ReverseAString {
    static void main() {

        manual("The quick brown fox");


    }

    public static void reserveUsingStringBuilder(String s){
        StringBuilder builder=new StringBuilder(s);
        System.out.println(builder.reverse());
    }

    public static void manual(String s){
        char[]c=s.toCharArray();
        int start=0;
        int end=c.length-1;
        char temp;
        while (start<end){
         temp=c[start];
         c[start]=c[end];
         c[end]=temp;
         start++;
         end--;
        }
        System.out.println(c);
    }
}
