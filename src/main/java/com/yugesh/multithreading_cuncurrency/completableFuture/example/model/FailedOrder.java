package com.yugesh.multithreading_cuncurrency.completableFuture.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FailedOrder extends Order {

    public FailedOrder() {
        super("FAILED");
    }
}
