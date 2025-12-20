package com.yugesh.dsa.problems.algorithm.slidingWindow.fixedWindow;

import java.util.ArrayList;
import java.util.List;

public class AverageOfArrayFixedSize {

     public static void main(String[] args) {

        int[]a={1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k=5;
        System.out.println(average(a,k));
    }

    public static List<Double> average(int[]a,int k){
        List<Double>list=new ArrayList<>();
        int left=0,windowSum=0;
        double avg=0;
        for(int i=0;i<k;i++){
            windowSum+=a[i];
        }
        avg= (double) windowSum /k;
        list.add(avg);

        for(int i=k;i<a.length;i++){
            windowSum+=a[i];
            windowSum-=a[left];
            avg= (double) windowSum /k;
            list.add(avg);
            left++;
        }
        return list;
    }
}
