package com.yugesh.dsa.problems.algorithm._2_frequencyMap.easy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyMap_1 {

    public static void main(String[] args) {

        int[]twoSumArray={2,7,11,15};
        int twoSumTarget=9;
        System.out.println(twoSum(twoSumArray,twoSumTarget));

        int[]duplicateArray={1,2,3,1};
        System.out.println(containsDuplicate(duplicateArray));

        int[]duplicates_2={1,2,3,1,2,3};
        System.out.println(containsDuplicate_2(duplicates_2,2));

        int[]majorityArray={2,2,1,1,1,2,2};
        System.out.println(majorityElement(majorityArray));

        String nonRepeating="aabb";
        System.out.println(firstNonRepeatingCharacter(nonRepeating));

        String sAnagram="rat",tAnagram="car";
        System.out.println(anagram(sAnagram,tAnagram));

        String ransomNote="aa",magazine="aab";
        System.out.println(ransomNotes(ransomNote,magazine));

        String jewels="z",stones="ZZ";
        System.out.println(jewelsAndStones(jewels,stones));
    }

    /**
     * Source: LeetCode
     * 📌 Problem Statement (clean, no hints)
     * You are given an integer array nums and an integer target.
     * Return indices of the two numbers such that they add up to target.
     * Each input has exactly one solution
     * You may not use the same element twice
     * You can return the answer in any order
     * invariant:All elements seen so far are remembered along with their indices,
     * such that at any point we can instantly know whether a value needed to complete the target has already appeared.
     * @param a
     * @param target
     * @return
     */
    public static List<Integer> twoSum(int[]a,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            int value=target-a[i];
            if(map.containsKey(value)){
                return List.of(map.get(value),i);
            }
            map.put(a[i],i);
        }
        return List.of();
    }

    /**
     * Problem 2 — Contains Duplicate
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given an integer array nums.
     * Return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     * @param a
     * @return
     */
    public static boolean containsDuplicate(int[]a){
        Map<Integer,Integer>map=new HashMap<>();
        for (int j : a) {
            if (map.containsKey(j)) {
                return true;
            }
            map.put(j,1);
        }
        return false;
    }

    /**
     * 🧩 Problem 3 — Contains Duplicate II
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given an integer array nums and an integer k.
     * Return true if there are two distinct indices i and j such that:
     * nums[i] == nums[j]
     * |i - j| ≤ k
     * Otherwise, return false.
     * @param a
     * @param k
     * @return
     */
    public  static boolean containsDuplicate_2(int[]a,int k){
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if (map.containsKey(a[i])) {
                if(i-map.get(a[i])<=k) {
                    return true;
                }
            }
            map.put(a[i],i);
        }
        return false;
    }

    /**
     * 🧩 Problem 4 — Majority Element
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given an integer array nums of size n.
     * Return the majority element — the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists.
     * @param a
     * @return
     */
    public static int majorityElement(int[]a){
        int n=a.length;
        int threshold=n/2;
        Map<Integer,Integer>map=new HashMap<>();
        for (int j : a) {

            int count=map.getOrDefault(j,0)+1;
            map.put(j,count);
            if(count>threshold){
                return j;
            }

        }
        return -1;
    }

    /**
     * 🧩 Problem 5 — First Unique Character in a String
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given a string s.
     * Return the index of the first non-repeating character in the string.
     * If it does not exist, return -1.
     * @param s
     * @return
     */
    public static int firstNonRepeatingCharacter(String s){
        Map<Character,Integer>map=new HashMap<>();
        for(Character c:s.toCharArray()){
            map.compute(c,(k,v)->v==null?1:v+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;

    }

    /**
     * 🧩 Problem 6 — Valid Anagram
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given two strings s and t.
     * Return true if t is an anagram of s, and false otherwise.
     * An anagram uses the same characters with the same frequencies, possibly in a different order.
     * @param s
     * @param t
     * @return
     */
    public static boolean anagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer>map=new HashMap<>();
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Character c:t.toCharArray()){
            if(!map.containsKey(c)) return false;
            map.put(c,map.get(c)-1);
            if(map.get(c)==0)map.remove(c);
        }
        return map.isEmpty();
    }

    /**
     * 🧩 Problem 7 — Ransom Note
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given two strings:
     * ransomNote
     * magazine
     * Return true if ransomNote can be constructed using the letters from magazine,
     * and false otherwise.
     * Each letter in magazine can be used at most once.
     * @param ransomNotes
     * @param magazine
     * @return
     */
    public static boolean ransomNotes(String ransomNotes, String magazine){
        if(ransomNotes.length()>magazine.length()){
            return false;
        }
        Map<Character,Integer>map=new HashMap<>();
        for(Character c:magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c:ransomNotes.toCharArray()){
           if(!map.containsKey(c)||map.get(c)==0){
               return false;
           }
           map.put(c,map.get(c)-1);

        }
        return true;
    }

    /**
     * 🧩 Problem 8 — Jewels and Stones
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given two strings:
     * jewels — characters that represent types of jewels
     * stones — characters that represent stones you have
     * Each character in stones is a stone you own.
     * Return the number of stones that are also jewels.
     * Characters are case-sensitive.
     * @param jewels
     * @param stones
     * @return
     */
//    public static int jewelsAndStones(String jewels, String stones){
//        int value=0;
//        if(stones.isEmpty()){
//            return value;
//        }
//        Map<Character,Integer>map=new HashMap<>();
//        for(Character s:stones.toCharArray()){
//            map.put(s,map.getOrDefault(s,0)+1);
//        }
//        for(Character j:jewels.toCharArray()){
//            if(map.containsKey(j)){
//                value=value+map.get(j);
//            }
//        }
//        return value;
//    }
    //simplest form
    //Frequency Map pattern includes SET membership as its simplest form.
    public static int jewelsAndStones(String jewels, String stones){
        Set<Character>set=new HashSet<>();
        for(Character s:stones.toCharArray()){
            set.add(s);
        }
        int count=0;
        for(Character j:jewels.toCharArray()){
            if(set.contains(j)){
                count++;
            }
        }
        return count;
    }
}
