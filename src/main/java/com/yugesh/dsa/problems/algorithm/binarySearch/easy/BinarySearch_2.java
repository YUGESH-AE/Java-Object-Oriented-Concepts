package com.yugesh.dsa.problems.algorithm.binarySearch.easy;

public class BinarySearch_2 {
    static void main() {
        int[]arrr={1,2,3,5,6,7};
        int targetArr=4;
        System.out.println(searchInsertPosition(arrr,targetArr));

        int[]floorArray={1, 2, 4, 6, 10};
        int floorTarget=5;
        System.out.println(floor(floorArray,floorTarget));

        int[]ceilArray={1, 2, 4, 6, 10};
        int ceilTarget=5;
        System.out.println(ceil(ceilArray,ceilTarget));

        int[]lowerBoundArray={1, 2, 4, 6, 10};
        int lowerBoundTarget=5;
        System.out.println(lowerBound(lowerBoundArray,lowerBoundTarget));

        int[]upperBoundArray={1, 2, 4, 4, 4, 6, 10};
        int upperBoundTarget=4;
        System.out.println(upperBound(upperBoundArray,upperBoundTarget));
    }

    public  static int searchInsertPosition(int[]a,int target){
        if(a==null ||a.length==0){
            return -1;
        }
        int left=0,right=a.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;

            if(a[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

    public static int floor(int[]a,int target){
        int value=-1;
        if(a==null||a.length==0){
            return value;
        }
        int left=0,right=a.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;

            if(a[mid]<=target){
                value=a[mid];
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return value;
    }

    public static int ceil(int[]a,int target){
        int value=-1;
        if(a==null||a.length==0){
            return value;
        }
        int left=0,right=a.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]>=target){
                value=a[mid];
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return value;
    }

    public static int lowerBound(int[]a,int target){
        int value=-1;
        if(a==null||a.length==0){
            return value;
        }
        int left=0,right=a.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;

            if(a[mid]>=target){
                value=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return value;
    }

    public static int upperBound(int[]a,int target){
        int value=-1;
        if(a==null||a.length==0){
            return value;
        }
        int left=0,right=a.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;

            if(a[mid]>target){
                value=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return value;
    }
}
