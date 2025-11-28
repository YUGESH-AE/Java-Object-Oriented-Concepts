package com.yugesh.generics;

import java.util.ArrayList;

public class GenericsExample {

    static void main() {

        ArrayList<String> list = new ArrayList<>();
        list.add("yugesh");
        list.add("raj");

        ArrayList newList = list;
        newList.add(100);
        System.out.println(list);
        System.out.println(newList.get(2));
    }

}
