package com.yugesh.generics;

import java.util.*;

public class GenericMethod {
    
    static void main(){

        Integer[]a={10,20,30,67,90,78,90};
        List<Integer>list=new ArrayList<>();
        System.out.println(GenericMethod.<Integer>convertArrayToList(a, list));

        String[]b={"yugesh","ravi","raj","ram"};
        List<String>strings=new ArrayList<>();
        System.out.println(GenericMethod.<String>convertArrayToList(b, strings));
    }

    public static <T> List<T> convertArrayToList(T[] array,List<T> list){

        for(T i:array){
            list.add(i);
        }
        return list;
    }


}
