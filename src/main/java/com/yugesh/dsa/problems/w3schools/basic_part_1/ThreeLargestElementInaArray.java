package com.yugesh.dsa.problems.w3schools.basic_part_1;

import java.util.*;
import java.util.function.Function;

public class ThreeLargestElementInaArray {

    static void main() {
       int[]a ={1, 4, 17, 7, 25, 3, 100};
       k_largest(a);
       k_smallest(a);
       k_th_smallestAndLargest(a);


    }

    public static void k_largest(int[]a){
        int[] b= Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i->i)
                .limit(3)
                .toArray();
        System.out.println(Arrays.toString(b));
    }
    public static void k_smallest(int[]a){
        int[] b= Arrays.stream(a)
                .sorted()
                .limit(3)
                .toArray();
        System.out.println(Arrays.toString(b));
    }

    public static void k_th_smallestAndLargest(int[]a){
        OptionalInt secondSmallest=Arrays.stream(a)
                .sorted()
                .skip(2-1)
                .findFirst();

        OptionalInt secondLargest=Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i->i)
                .skip(2-1)
                .findFirst();
        System.out.println("2nd smallest:"+secondSmallest.getAsInt());
        System.out.println("2nd largest:"+secondLargest.getAsInt());
    }
}
