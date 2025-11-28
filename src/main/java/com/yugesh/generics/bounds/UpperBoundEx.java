package com.yugesh.generics.bounds;

import java.util.List;
import java.util.function.BinaryOperator;

public class UpperBoundEx {

    static void main() {

        System.out.println(sumIntValues(List.of(23.78, 787.90, 89.78), 0.0, Double::sum));
        System.out.println(sumIntValues(List.of(2.3f, 34.34f, 80.3f), 0f, Float::sum));

    }


    public static <E extends Number> E sumIntValues(List<E> listOfNumber, E identity, BinaryOperator<E> opt) {


        E sum = identity;
        for (E i : listOfNumber) {
            sum = opt.apply(i, sum);
        }
        return sum;
    }


}


