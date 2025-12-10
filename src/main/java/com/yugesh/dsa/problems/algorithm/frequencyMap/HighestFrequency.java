package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HighestFrequency {
    static void main() {

        int[]a={4, 5, 4, 5, 4, 6, 5};
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                int value=map.get(a[i]);
                map.replace(a[i],value+1);
            }else {
                map.put(a[i],1);
            }
        }
        System.out.println(map);

        int start=0;

        for(int i=1;i<a.length;i++){
            if(map.get(a[start])>=map.get(a[i])){
                System.out.println(a[start]);
                return;
            }
            start++;

        }
    }
}
