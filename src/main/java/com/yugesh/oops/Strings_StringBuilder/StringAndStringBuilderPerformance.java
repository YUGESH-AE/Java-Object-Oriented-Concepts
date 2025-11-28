package com.yugesh.oops.Strings_StringBuilder;

public class StringAndStringBuilderPerformance {

    static void main() {
        int n = 100_000;

        // --- Using String ---
        long startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + i; // creates a new object every time
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Using String took: " + (endTime - startTime) + " ms");

        // --- Using StringBuilder ---
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i); // modifies same object
        }
        sb.toString();
        endTime = System.currentTimeMillis();
        System.out.println("Using StringBuilder took: " + (endTime - startTime) + " ms");
    }
}
