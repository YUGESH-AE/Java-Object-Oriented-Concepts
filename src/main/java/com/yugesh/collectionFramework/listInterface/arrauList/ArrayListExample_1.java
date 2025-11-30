package com.yugesh.collectionFramework.listInterface.arrauList;

import java.util.*;

public class ArrayListExample_1 {
    static void main() {
        // Creating ArrayList
        List<String> fruits = new ArrayList<>();

        // ===== ADDING ELEMENTS =====
        fruits.add("Apple");           // add(E e)
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("After add: " + fruits);

        fruits.add(1, "Mango");        // add(int index, E element)
        System.out.println("After add at index 1: " + fruits);

        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("Grape");
        moreFruits.add("Pineapple");
        fruits.addAll(moreFruits);     // addAll(Collection c)
        System.out.println("After addAll: " + fruits);

        fruits.addAll(2, moreFruits);  // addAll(int index, Collection c)
        System.out.println("After addAll at index 2: " + fruits);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\nSize: " + fruits.size());           // size()
        System.out.println("Is empty: " + fruits.isEmpty());      // isEmpty()

        // ===== ACCESSING ELEMENTS =====
        System.out.println("\nElement at index 0: " + fruits.get(0));  // get(int index)

        // ===== CONTAINS =====
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));        // contains(Object o)
        System.out.println("Contains 'Kiwi': " + fruits.contains("Kiwi"));

        List<String> checkList = new ArrayList<>();
        checkList.add("Apple");
        checkList.add("Banana");
        System.out.println("Contains all in checkList: " + fruits.containsAll(checkList)); // containsAll()

        // ===== FINDING INDEX =====
        System.out.println("\nIndex of 'Banana': " + fruits.indexOf("Banana"));     // indexOf()
        System.out.println("Last index of 'Grape': " + fruits.lastIndexOf("Grape")); // lastIndexOf()

        // ===== SETTING ELEMENT =====
        String oldValue = fruits.set(0, "Avocado");  // set(int index, E element)
        System.out.println("Replaced '" + oldValue + "' with 'Avocado': " + fruits);

        // ===== REMOVING ELEMENTS =====
        fruits.remove("Pineapple");    // remove(Object o)
        System.out.println("After remove 'Pineapple': " + fruits);

        fruits.remove(2);              // remove(int index)
        System.out.println("After remove index 2: " + fruits);

        List<String> toRemove = new ArrayList<>();
        toRemove.add("Grape");
        toRemove.add("Mango");
        fruits.removeAll(toRemove);    // removeAll(Collection c)
        System.out.println("After removeAll: " + fruits);

        // ===== RETAIN ALL =====
        List<String> items = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Grape"));
        List<String> retain = new ArrayList<>(Arrays.asList("Apple", "Banana"));
        items.retainAll(retain);       // retainAll(Collection c)
        System.out.println("\nAfter retainAll: " + items);

        // ===== REMOVE IF =====
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        numbers.removeIf(n -> n % 2 == 0);  // removeIf(Predicate filter)
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== SUBLIST =====
        List<String> allFruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Grape", "Mango"));
        List<String> subList = allFruits.subList(1, 4);  // subList(int fromIndex, int toIndex)
        System.out.println("\nSublist from 1 to 4: " + subList);

        // ===== ITERATOR =====
        System.out.println("Using Iterator:");
        Iterator<String> iter = allFruits.iterator();   // iterator()
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // ===== LIST ITERATOR =====
        System.out.println("Using ListIterator (forward):");
        ListIterator<String> listIter = allFruits.listIterator();  // listIterator()
        while (listIter.hasNext()) {
            System.out.print(listIter.next() + " ");
        }
        System.out.println("\nUsing ListIterator (backward):");
        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + " ");
        }
        System.out.println();

        // ===== LIST ITERATOR FROM INDEX =====
        ListIterator<String> listIterFromIndex = allFruits.listIterator(2);  // listIterator(int index)
        System.out.println("ListIterator from index 2: " + listIterFromIndex.next());

        // ===== STREAM AND PARALLEL STREAM =====
        System.out.println("\nUsing Stream:");
        allFruits.stream().forEach(System.out::println);  // stream()

        // ===== SORT =====
        List<String> sortList = new ArrayList<>(Arrays.asList("Zebra", "Apple", "Mango", "Banana"));
        sortList.sort(String::compareTo);  // sort(Comparator c)
        System.out.println("After sort: " + sortList);

        // ===== REPLACE ALL =====
        List<String> replaceList = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        replaceList.replaceAll(s -> s.toUpperCase());  // replaceAll(UnaryOperator operator)
        System.out.println("After replaceAll (uppercase): " + replaceList);

        // ===== TO ARRAY =====
        String[] array = allFruits.toArray(new String[0]);  // toArray(T[] a)
        System.out.println("\nConverted to array: " + Arrays.toString(array));

        // ===== EQUALS =====
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("list1 equals list2: " + list1.equals(list2));  // equals(Object o)

        // ===== HASH CODE =====
        System.out.println("HashCode of list1: " + list1.hashCode());  // hashCode()

        // ===== CLEAR =====
        List<String> clearList = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        clearList.clear();  // clear()
        System.out.println("After clear: " + clearList);
    }
}