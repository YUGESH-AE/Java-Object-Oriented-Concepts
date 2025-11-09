package com.yugesh.arrays_arraylist;

import java.util.Arrays;

public class CustomArrayListByGenerics<T>{

    private Object[] data;

    private static int DEFAULT_SIZE=10;

    private int size=0;

    public CustomArrayListByGenerics(){
        this.data= new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }

    private void resize() {
        Object[]temp=new Object[data.length*2];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }

    public T remove(){
        return (T) data[--size];
    }

    public int get(int index){
        return (int) data[index];
    }

    public int size(){
        return size;


    }

    public void set(int index,T value){
        data[index]=value;
    }

    @Override
    public String toString() {
        return "CustomArrayListByGenerics{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    static void main(){
        CustomArrayListByGenerics<Integer>list=new CustomArrayListByGenerics<>();
        list.add(10);
        list.add(20);
        System.out.println(list);
    }
}
