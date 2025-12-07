package com.yugesh;

import com.yugesh.featuresOfJava_8.streams.fullExamples.Employee;
import com.yugesh.featuresOfJava_8.streams.fullExamples.Main;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Learning {

    static void main() {


        Map<Integer, String> map = Main.employeeList()
                .stream()
                .collect(
                        Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        )
                );
        TreeMap<Integer, String> maps = new TreeMap<>(map);
        String v1 = maps.putIfAbsent(40, "yugesh");
        System.out.println(v1);
        maps.putIfAbsent(1, "Arjun");
        maps.replace(2, "sandhaya", "Kavya");
        String value1 = maps.computeIfAbsent(0, k -> "Ravi");
        String value2 = maps.computeIfPresent(0, (k, v) -> "Sanjay");
        System.out.println(value1);
        System.out.println(value2);
        maps.compute(0, (k, v) -> v + "-yugesh");
        System.out.println(maps);
//        maps.forEach((k,v)-> System.out.println("Key:"+k+"  "+"value:"+v));

        System.out.println(maps.lowerEntry(4));
        System.out.println(maps.lowerKey(4));


    }
}
