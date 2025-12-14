package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicates {

    static void main() {
        String s="abbacab";
        System.out.println(removeAdjacentDuplicate(s));
    }

    public static String removeAdjacentDuplicate(String s){

        if(s==null ||s.isEmpty()) return null;

        Deque<Character>stack=new ArrayDeque<>();

        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else {
                if(stack.peek()!=ch){
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }
        StringBuilder builder=new StringBuilder();
        for(char c:stack){
            builder.append(c);
        }
        return builder.reverse().toString();
    }
}
