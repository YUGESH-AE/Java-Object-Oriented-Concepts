package com.yugesh.multithreading_cuncurrency.completableFuture.example.service;

import com.yugesh.multithreading_cuncurrency.completableFuture.example.model.Order;

public class OrderService {

    public static Order getOrder() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Order("ORDER");
    }

    public static Order enrich(Order o) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public static Order performPayment(Order o) {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public static Order dispatch(Order o) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public static void sendEmail(Order o) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email sent for order id:" + o.getId());
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
