package com.yugesh.collectionFramework.iterator;

import java.util.Iterator;

public class CollectionIteratorExample {

    static void main() {

        CollectionIterable<Integer> list = new CollectionIterable<>(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);

        for (Integer i : list) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

class CollectionIterable<T> implements Iterable<T> {


    private final T[] data;
    private int size;

    public CollectionIterable(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T value) {
        data[size++] = value;
    }


    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator();
    }

    private class CollectionIterator implements Iterator<T> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return data[index++];
        }
    }
}