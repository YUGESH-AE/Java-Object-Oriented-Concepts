package com.yugesh.dsa.problems.algorithm.slidingWindow.fixedWindow;

public class MaxSumSubArray {

    static void main() {

        int[]a={2, 1, 5, 1, 3, 2};
        int k=3;

        System.out.println(maxSumSub(a,k));
    }

    public static int maxSumSub(int[]a, int k){
        if(a==null ||a.length<k) return -1;

        int windowSum=0;

        for(int i=0;i<k;i++){
            windowSum+=a[i];
        }
        int max=windowSum;

        int left=0;
        for(int right=k;right<a.length;right++){
            windowSum+=a[right];
            windowSum-=a[left];
            left++;
            max=Math.max(max,windowSum);
        }
        return max;
    }
}
