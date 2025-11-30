package com.yugesh.featuresOfJava_8.functionalInterface;

import java.util.function.Supplier;

public class SupplierExample_1 {

    static void main() {

        Supplier<Double> supplier = Math::random;
        Double value = supplier.get();
        System.out.println(value);
    }
}
