package com.yugesh;

public class CPUCheck {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors (cores/threads): " + cores);
    }
}
