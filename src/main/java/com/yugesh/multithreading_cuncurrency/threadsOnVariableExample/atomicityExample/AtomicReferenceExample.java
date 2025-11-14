package com.yugesh.multithreading_cuncurrency.atomicityExample;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    public static class User{

        String name;

        public User(String name) {
            this.name = name;
        }
    }

    static void main() {
        
        AtomicReference<User> ref = new AtomicReference<>(new User("Alice"));
        User oldUser = ref.get();

        User newUser = new User("Bob");
        boolean updated = ref.compareAndSet(oldUser, newUser);

        System.out.println("Updated: " + updated + ", Current User: " + ref.get().name);
    }
    
}
