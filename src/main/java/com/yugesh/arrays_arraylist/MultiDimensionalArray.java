package com.yugesh.arrays_arraylist;

import java.util.Arrays;

public class MultiDimensionalArray  {

    static void main() {
        int[][]a={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

//        System.out.println(Arrays.toString(a[1]));

        for(int row=0;row< a.length;row++){
            for(int col=0;col<a[row].length;col++){
                System.out.print(a[row][col]+" ");
            }
            System.out.println();
        }

        for(int[] row:a){
            System.out.println(Arrays.toString(row));
        }
    }


}
