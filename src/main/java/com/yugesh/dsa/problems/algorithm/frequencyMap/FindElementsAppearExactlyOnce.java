package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindElementsAppearExactlyOnce {
    static void main() {

        int[]a={1, 2, 2, 3, 4, 4, 5};
        findExactlyOne(a);

        
    }

    public static void findExactlyOne(int[]a){
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                int value=map.get(a[i]);
                map.replace(a[i],value+1);
            }else {
                map.put(a[i],1);
            }
        }
        List<Integer>list=new ArrayList<>();
        for (Map.Entry<Integer,Integer>i:map.entrySet()){
            if(i.getValue()==1){
                list.add(i.getKey());
            }
        }
        System.out.println(list);
    }

}
