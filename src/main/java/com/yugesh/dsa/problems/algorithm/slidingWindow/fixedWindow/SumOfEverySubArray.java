package com.yugesh.dsa.problems.algorithm.slidingWindow.fixedWindow;

import java.util.ArrayList;
import java.util.List;

public class SumOfEverySubArray {
    static void main() {

        int[]a={2, 1, 5, 1, 3, 2};
        System.out.println(sumOfSubArray(a,3));
    }

    public static List<Integer> sumOfSubArray(int[]a,int k){
        List<Integer>list=new ArrayList<>();

        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum+=a[i];
        }
        list.add(windowSum);

        int left=0;
        for(int right=k;right<a.length;right++){
            windowSum+=a[right];
            windowSum-=a[left];
            list.add(windowSum);
            left++;
        }
        return list;
    }
}
