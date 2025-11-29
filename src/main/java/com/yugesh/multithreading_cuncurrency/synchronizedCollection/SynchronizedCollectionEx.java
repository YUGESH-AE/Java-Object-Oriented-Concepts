package com.yugesh.multithreading_cuncurrency.synchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx {

    static void main() {
        try {
            List<Integer> list = Collections.synchronizedList(new ArrayList<>());

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
