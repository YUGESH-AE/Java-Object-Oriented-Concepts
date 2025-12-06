package com.yugesh.collectionFramework.arrays_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiDimensionalArrayList {


    static void main() {



        try ( Scanner scanner = new Scanner(System.in);) {
            

            List<List<Integer>> multiList = new ArrayList<>();

        System.out.println("Enter the outer list size:: ");
        int outSize = scanner.nextInt();
        System.out.println("Enter the inner list size");
        int innerSize = scanner.nextInt();

        for (int i = 0; i < outSize; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < innerSize; j++) {
                System.out.println("Enter the number:");
                Integer a = scanner.nextInt();
                innerList.add(a);

            }
            multiList.add(innerList);
        }
        System.out.println("Your 2D ArrayList:");
        for (List<Integer> row : multiList) {
            System.out.println(row);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       

        


    }


}
