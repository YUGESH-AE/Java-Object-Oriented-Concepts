package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingNumber {

    static void main() {
        int[]a={4, 5, 1, 2, 0, 4};
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
        for(Map.Entry<Integer,Integer>i:map.entrySet()){
            if(i.getValue()==1){
                System.out.println("First non repeating: "+i.getKey());
                return;
            }
        }
    }
}
