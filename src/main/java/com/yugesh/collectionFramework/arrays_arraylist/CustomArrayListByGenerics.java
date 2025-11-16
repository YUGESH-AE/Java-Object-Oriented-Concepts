package com.yugesh.collectionFramework.arrays_arraylist;

import java.util.Arrays;

public class CustomArrayListByGenerics<T> {

    private static int DEFAULT_SIZE = 10;
    private T[] data;
    private int size = 0;

    public CustomArrayListByGenerics() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    static void main() {
        CustomArrayListByGenerics<Integer> list = new CustomArrayListByGenerics<Integer>();
        list.add(10);
        list.add(20);
        System.out.println(list);
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        return (T) data[--size];
    }

    public int get(int index) {
        return (int) data[index];
    }

    public int size() {
        return size;


    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayListByGenerics{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    private void resize() {
        T[] temp = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
