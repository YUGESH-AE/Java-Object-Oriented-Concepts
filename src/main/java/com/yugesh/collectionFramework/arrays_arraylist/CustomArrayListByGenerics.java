package com.yugesh.collectionFramework.arrays_arraylist;

import java.util.Arrays;

public class CustomArrayListByGenerics<T> {

    private static final int DEFAULT_SIZE = 10;
    private T[] data;
    private int size = 0;

    public CustomArrayListByGenerics() {
        // unavoidable unchecked cast when creating generic array
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[DEFAULT_SIZE];
        this.data = arr;
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
        return data[--size];
    }

    public T get(int index) {
        return data[index];
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
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
}
