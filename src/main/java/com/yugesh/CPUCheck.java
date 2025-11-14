package com.yugesh;

public class CPUCheck {

    static void main() {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors (cores/threads): " + cores);
    }
}
