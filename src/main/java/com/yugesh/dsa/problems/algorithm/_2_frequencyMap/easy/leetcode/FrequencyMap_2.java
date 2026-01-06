package com.yugesh.dsa.problems.algorithm._2_frequencyMap.easy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequencyMap_2 {

    public static void main(String[] args) {

        int[]nums1={4,9,5};
        int[]nums2={9,4,9,8,4};
        System.out.println(intersectionOfArrays(nums1,nums2));
    }

    /**
     * 🧩 Problem 9 — Intersection of Two Arrays
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given two integer arrays nums1 and nums2.
     * Return an array of their intersection.
     * Each element in the result must be unique, and you may return the result in any order.
     * @param num1
     * @param num2
     * @return
     */
    public static List<Integer> intersectionOfArrays(int[]num1,int[] num2){
        Set<Integer>set=new HashSet<>();
        Set<Integer>sets=new HashSet<>();

        for(int i:num1){
            set.add(i);
        }
        for(int i:num2){
            if(set.contains(i)){
                sets.add(i);
            }
        }
        return new ArrayList<>(sets);
    }
}
