package com.yugesh.dsa.problems.algorithm._1_twoPointer.slowFast;

import java.util.Arrays;
import java.util.List;

public class RemoveOccurrences {

    static void main() {

        int[] a = {3, 2, 2, 3, 4};
        System.out.println(occurrences1(a, 3));
        System.out.println(occurrences2(a, 3));
    }

    public static int occurrences1(int[] a, int x) {


        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(a)
                .boxed().toList());

        list.removeIf(i -> i == x);
        System.out.println(list);

        return list.size();
    }

    public static int occurrences2(int[] a, int x) {
        int slow = 0;
        for (int fast = 0; fast < a.length; fast++) {
            if (a[fast] != x) {
                a[slow] = a[fast];
                slow++;
            }
        }
        return slow;
    }

}
