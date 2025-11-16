package com.yugesh.collectionFramework.listInterface;

import java.util.Stack;

public class StackExample {

    static void main() {

        Stack<String> stack = new Stack<>();

        //push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);

        //peek top of the stack
        System.out.println(stack.peek());

        //pop removing the top most element
        System.out.println(stack.pop());

        System.out.println(stack);

        //search the element in the stack
        System.out.println("Position of A:" + stack.search("A"));
    }
}
