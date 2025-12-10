package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCounting {
    static void main() {
        int[]a={1, 2, 2, 3, 3, 3};

        Map<Integer,Long> map=new HashMap<>();

        for(int i:a){
            map.compute(i,(k,v)->v==null?1:v+1);
        }
        System.out.println(map);

        Map<Integer,Long>mapStream= Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(mapStream);

        Map<Integer,Integer>mapJava=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(mapJava.containsKey(a[i])){
                int v=mapJava.get(a[i]);
                mapJava.replace(a[i],v+1);
            }else {
                mapJava.put(a[i], 1);
            }
        }
        System.out.println(mapJava);
    }
}
