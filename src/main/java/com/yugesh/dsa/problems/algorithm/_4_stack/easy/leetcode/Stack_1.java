package com.yugesh.dsa.problems.algorithm._4_stack.easy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_1 {

    public static void main(String[] args) {

        String parentheses = "([)]";
        System.out.println(validParentheses(parentheses));

        String adjacent="abbaca";
        System.out.println(removeAdjacentDuplicates(adjacent));

        String s1="ab#c",s2="ad#c";
        System.out.println(backSpaceStringCompareTwoPointer(s1,s2));

        String[]ops={"5","2","C","D","+"};
        System.out.println(baseBall(ops));

    }

    /**
     * Valid Parentheses — the “Hello World” of stack discipline — but also the first real test of invariant thinking.
     * From LeetCode
     * 🧩 Problem (Clean Statement)
     * Given a string s containing only:
     * ( ) { } [ ]
     * <p>
     * Determine if the string is valid.
     * A string is valid if:
     * Open brackets are closed by the same type.
     * Open brackets are closed in the correct order.
     * Every closing bracket has a matching opening bracket.
     *
     * @param s
     * @return
     */
    public static boolean validParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] c = s.toCharArray();

        for (char i : c) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((top == '(' && i != ')') ||
                        (top == '{' && i != '}') ||
                        (top == '[' && i != ']')
                ) {
                    return false;
                }
                stack.pop();

            }
        }
        return stack.isEmpty();
    }

    /**
     * From LeetCode
     * Remove All Adjacent Duplicates in String
     *
     * 🧩 Problem
     *
     * Given a string s, repeatedly remove adjacent duplicate characters until no duplicates remain.
     *
     * Return the final string.
     *
     * Input:  "abbaca"
     * Output: "ca"
     * Because:
     *
     * "abbaca"
     * remove "bb" → "aaca"
     * remove "aa" → "ca"
     * done
     * The Stack Invariant
     * This problem is beautiful because the invariant is very clean:
     * The stack always contains the string after processing characters up to the current index — with no adjacent duplicates.
     * @param s
     * @return
     */
    public static String removeAdjacentDuplicates(String s){
        Deque<Character>stack=new ArrayDeque<>();

        for(char c:s.toCharArray()){

            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else {
                stack.push(c);
            }

        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static boolean backSpaceStringCompareTwoPointer(String s1, String s2){
        int i=s1.length()-1;
        int j=s2.length()-1;

        int skip1=0;
        int skip2=0;
        while (i>=0|| j>=0){

            while (i>=0){
               if(s1.charAt(i)=='#'){
                   skip1++;
                   i--;
               } else if (skip1>0) {
                   skip1--;
                   i--;
               }else {
                   break;
               }
            }

            while (j>=0){
                if(s2.charAt(j)=='#'){
                    skip2++;
                    j--;
                } else if (skip2>0) {
                    skip2--;
                    j--;
                }else {
                    break;
                }
            }

            if(i>=0&&j>=0){
                if(s1.charAt(i)!=s2.charAt(j)){
                    return false;
                }
            }else{
                if(i>=0||j>=0){
                    return false;
                }
            }
            i--;
            j--;
        }

        return true;
    }

    public static boolean backSpaceStringCompare2(String s1,String s2){

        return build(s1).equals(build(s2));
    }

    private static String build(String s){
        Deque<Character>stack=new ArrayDeque<>();

        for(char i:s.toCharArray()){
            if(i!='#'){
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    /**
     * From LeetCode
     * Baseball Game
     * 🧩 Problem
     * You’re given an array of operations ops.
     * Each element is one of:
     * An integer → record that score
     * "+" → score = sum of last two valid scores
     *
     * "D" → score = double the last valid score
     *
     * "C" → invalidate (remove) the last valid score
     * Return the total sum of all valid scores.
     * @param ops
     * @return
     */
    public static int baseBall(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : ops) {

            switch (op) {

                case "+":
                    int top = stack.pop();
                    int newScore = top + stack.peek();
                    stack.push(top);
                    stack.push(newScore);
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "C":
                    stack.pop();
                    break;

                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}
