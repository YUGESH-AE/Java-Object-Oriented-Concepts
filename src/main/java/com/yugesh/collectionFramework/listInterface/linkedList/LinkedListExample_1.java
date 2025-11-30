package com.yugesh.collectionFramework.listInterface.linkedList;

import java.util.*;

public class LinkedListExample_1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // ===== COLLECTION INTERFACE METHODS =====
        System.out.println("===== COLLECTION METHODS =====");
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("After add: " + list);

        List<String> moreItems = new LinkedList<>();
        moreItems.add("Grape");
        moreItems.add("Mango");
        list.addAll(moreItems);
        System.out.println("After addAll: " + list);

        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println("Contains 'Apple': " + list.contains("Apple"));
        System.out.println("Contains 'Kiwi': " + list.contains("Kiwi"));

        List<String> checkList = new LinkedList<>();
        checkList.add("Apple");
        checkList.add("Banana");
        System.out.println("Contains all: " + list.containsAll(checkList));

        list.remove("Grape");
        System.out.println("After remove('Grape'): " + list);

        List<String> toRemove = new LinkedList<>();
        toRemove.add("Mango");
        list.removeAll(toRemove);
        System.out.println("After removeAll: " + list);

        List<String> items = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> retain = new LinkedList<>(Arrays.asList("A", "C"));
        items.retainAll(retain);
        System.out.println("After retainAll: " + items);

        List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== LIST INTERFACE METHODS =====
        System.out.println("\n===== LIST METHODS =====");
        List<String> fruits = new LinkedList<>(Arrays.asList("Apple", "Banana", "Orange"));

        System.out.println("Get index 0: " + fruits.get(0));
        System.out.println("Get index 2: " + fruits.get(2));

        fruits.add(1, "Mango");
        System.out.println("After add at index 1: " + fruits);

        List<String> insertList = new LinkedList<>();
        insertList.add("Grape");
        insertList.add("Kiwi");
        fruits.addAll(2, insertList);
        System.out.println("After addAll at index 2: " + fruits);

        String oldValue = fruits.set(0, "Avocado");
        System.out.println("After set(0, 'Avocado'), replaced: " + oldValue);
        System.out.println("List now: " + fruits);

        fruits.remove(1);
        System.out.println("After remove index 1: " + fruits);

        System.out.println("Index of 'Banana': " + fruits.indexOf("Banana"));
        System.out.println("Last index of 'Grape': " + fruits.lastIndexOf("Grape"));

        List<String> subList = fruits.subList(1, 4);
        System.out.println("SubList(1, 4): " + subList);

        System.out.println("Using Iterator:");
        Iterator<String> iter = fruits.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Using ListIterator (forward):");
        ListIterator<String> listIter = fruits.listIterator();
        while (listIter.hasNext()) {
            System.out.print(listIter.next() + " ");
        }
        System.out.println("\nUsing ListIterator (backward):");
        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + " ");
        }
        System.out.println();

        ListIterator<String> listIterFromIndex = fruits.listIterator(2);
        System.out.println("ListIterator from index 2: " + listIterFromIndex.next());

        List<String> sortList = new LinkedList<>(Arrays.asList("Zebra", "Apple", "Mango", "Banana"));
        sortList.sort(String::compareTo);
        System.out.println("After sort: " + sortList);

        List<String> replaceList = new LinkedList<>(Arrays.asList("apple", "banana", "orange"));
        replaceList.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll: " + replaceList);

        String[] array = fruits.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));

        List<String> list1 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        list1.addFirst("0");
        List<String> list2 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        list2.addLast("Z");
        System.out.println("list1 equals list2: " + list1.equals(list2));
        System.out.println("HashCode: " + list1.hashCode());


    }
}