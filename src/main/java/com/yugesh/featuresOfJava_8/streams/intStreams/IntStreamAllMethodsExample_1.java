package com.yugesh.featuresOfJava_8.streams.intStreams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamAllMethodsExample_1 {

    static void main() {

        //range(int start, int end)
        //Creates a stream from start (inclusive) to end (exclusive).
        int[] intRange = IntStream.range(1, 5).toArray();
        System.out.println(Arrays.toString(intRange));

        //rangeClosed(int start, int end)
        //Same as range, but end is inclusive.
        int[] intRangeInclusive = IntStream.rangeClosed(1, 5).toArray();
        System.out.println(Arrays.toString(intRangeInclusive));

        //Returns the sum of all integers.
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

        //Computes the average as an OptionalDouble.
        double avg = IntStream.rangeClosed(1, 10).average().getAsDouble();
        System.out.println(avg);

        //Returns the minimum element as OptionalInt.
        System.out.println(IntStream.range(1, 20).min().getAsInt());

        //Returns the maximum element as OptionalInt.
        System.out.println(IntStream.range(1, 20).max().getAsInt());

        //Counts number of elements.
        System.out.println(IntStream.range(1, 20).count());

        //Returns IntSummaryStatistics with:
        //
        //count
        //
        //sum
        //
        //min
        //
        //max
        //
        //average
        var stats = IntStream.of(1, 2, 3, 4).summaryStatistics();
        System.out.println(stats.getSum());       // 10
        System.out.println(stats.getMax());       // 4
        System.out.println(stats.getMin());       // 1
        System.out.println(stats.getAverage());   // 2.5
        System.out.println(stats.getCount());     // 4
    }
}
