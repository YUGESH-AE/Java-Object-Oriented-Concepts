package com.yugesh.dsa.problems.algorithm._2_frequencyMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterWithHighFrequency {
    static void main() {
        String s = "abbcccddddeeeeee";
        System.out.println(frequency(s));
    }


    public static char frequency(String s) {

        if (s == null) return ' ';
        char[] c = s.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char i : c) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int max = 0;
        char x = ' ';
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                x = m.getKey();
            }
        }
        return x;

    }
}
