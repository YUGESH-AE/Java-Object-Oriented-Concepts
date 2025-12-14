package com.yugesh.dsa.problems.algorithm.slidingWindow.variableWindow;

public class MinLengthOfSubArrayWithTarget {

    static void main() {

        int[]a={2, 3, 1, 2, 4, 3};
        int target=7;
        System.out.println(count(a,target));
    }

    public static int count(int[]a,int target){
        if(a==null ||a.length==0) return 0;

        int left=0;
        int windowSum=0,min=Integer.MAX_VALUE;

        for(int right=0;right<a.length;right++){
            windowSum+=a[right];

            while (windowSum>=target){
                min=Math.min(min,(right-left)+1);
                windowSum-=a[left];
                left++;
            }

        }
        return  min;
    }
}
