package com.yugesh.dsa.problems.algorithm._1_twoPointer.easy.leetcode;

import java.util.Arrays;

public class TwoPointers_3_LittleBitHarder {

    static void main() {

        int[]container={1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater(container));

        int[]removeDuplicates_2={1,1,1,2,2,3};
        System.out.println(removeDuplicates2(removeDuplicates_2));
    }

    /**
     * leetcode
     * Problem recap (in plain language)
     * You are given heights of vertical lines
     * Pick two lines
     * Water =min(height[left], height[right]) × (right - left)
     * Maximize the water
     * @param heights
     * @return
     */
    public static int containerWithMostWater(int[]heights){
        int left=0,right=heights.length-1,max=0;

        while (left<right){
            int width=right-left;
            int minHeight=Math.min(heights[left],heights[right]);
            int area=width*minHeight;
            max=Math.max(max,area);
            if(heights[left]<heights[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static int removeDuplicates2(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int slow = 0;
        int count = 1; // count of current element

        for (int fast = 1; fast < a.length; fast++) {

            if (a[fast] == a[slow]) {
                if (count < 2) {
                    slow++;
                    int temp=a[slow];
                    a[slow] = a[fast];
                    a[fast]=temp;
                }
                count++;
            } else {
                // new number
                slow++;
                a[slow] = a[fast];
                count = 1;
            }
        }

        System.out.println(Arrays.toString(a));
        return slow + 1;
    }

}
