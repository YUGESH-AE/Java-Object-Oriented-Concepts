package com.yugesh.dsa.problems.algorithm.binarySearch;

public class Basic {

    public static void main(String[] args) {
        int[]a={1, 3, 5, 7, 9, 11};
        int k=7;
        System.out.println(search(a,k));
    }

    public static int search(int[]a,int k){

        int left=0,right=a.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]==k){
                return mid;
            } else if (a[mid]<k) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
