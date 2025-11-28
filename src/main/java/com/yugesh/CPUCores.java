package com.yugesh;

public class CPUCores {

    public static int getCpuCores() {

        return Runtime.getRuntime().availableProcessors();
    }
}
