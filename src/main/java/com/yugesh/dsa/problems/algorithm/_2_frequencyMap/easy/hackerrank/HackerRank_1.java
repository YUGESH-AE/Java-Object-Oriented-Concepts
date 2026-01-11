package com.yugesh.dsa.problems.algorithm._2_frequencyMap.easy.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank_1 {
    static void main() {

        int[] a = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(a));

        String[] strings = {"aba", "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab"};

        System.out.println(sparseArray(strings, queries));


    }

    /**
     * 🧩 HackerRank — Sock Merchant
     * Source: HackerRank
     * 📌 Problem Statement (clean)
     * You are given an array of integers where each integer represents the color of a sock.
     * A pair is two socks with the same color.
     * Return the total number of matching pairs.
     *
     * @param a
     * @return
     */
    public static int sockMerchant(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            count = count + (m.getValue() / 2);
        }
        return count;
    }

    /**
     * 🧩 HackerRank — Sparse Arrays
     * Source: HackerRank
     * 📌 Problem Statement (clean)
     * You are given:
     * A list of strings strings
     * A list of query strings queries
     * For each query, determine how many times it appears in strings.
     * Return a list of counts corresponding to each query.
     *
     * @param strings
     * @param queries
     * @return
     */
    public static List<Integer> sparseArray(String[] strings, String[] queries) {

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }

        for (String q : queries) {
            list.add(map.getOrDefault(q, 0));
        }
        return list;

    }

}
