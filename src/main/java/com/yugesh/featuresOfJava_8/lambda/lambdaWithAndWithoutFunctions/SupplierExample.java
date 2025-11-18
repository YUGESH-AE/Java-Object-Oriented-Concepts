package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierExample {

    static void main() {

        //Before Lambda
        Supplier<LocalDateTime>dateTimeSupplier=new Supplier<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };
        System.out.println("Without lambda:"+dateTimeSupplier.get());

        //After Lambda

        Supplier<LocalTime>timeSupplier=()->LocalTime.now();

        System.out.println("Current time:"+timeSupplier.get());

    }
}
