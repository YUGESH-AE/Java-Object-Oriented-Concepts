package com.yugesh.dsa.problems.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {
    static void main() {
        String s = "({[]})";
        System.out.println(balanced(s));
    }

    public static boolean balanced(String s) {
        if(s==null ||s.isEmpty()) return false;

        Deque<Character>stack=new ArrayDeque<>();

        for(char ch:s.toCharArray()){
            if(ch=='(' ||ch=='{' || ch=='['){
                stack.push(ch);
            }else{

                if(stack.isEmpty()) return false;

                char top=stack.pop();

                if(ch==')' && top!='(') return false;
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
            }
        }
        return stack.isEmpty();

    }
}
