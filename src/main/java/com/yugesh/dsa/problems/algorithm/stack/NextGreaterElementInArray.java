package com.yugesh.dsa.problems.algorithm.stack;

import java.util.*;

public class NextGreaterElementInArray {

    static void main() {

        int[]a={4,5,2,25};
        System.out.println(nge(a));
    }

    public static List<Integer> nge(int[]a){


        int n=a.length;
        int[]result=new int[n];
        Arrays.fill(result,-1);

        Deque<Integer>stack=new ArrayDeque<>();//stores index
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&a[i]>a[stack.peek()]){
                int index=stack.pop();
                result[index]=a[i];
            }
            stack.push(i);
        }

        List<Integer>list=new ArrayList<>();
        for(int i:result){
            list.add(i);
        }
        return list;
    }
}
