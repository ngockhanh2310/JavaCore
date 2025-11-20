package org.workspace.learn.basic.collections.list;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        System.out.println(fruits);

        // 1 For loop - Vòng lặp for
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("Index " + i + ": " + fruits.get(i));
        }

        // 2 For-each loop - Vòng lặp for-each
        for (String arr : fruits) {
            System.out.println("Fruits: " + arr);
        }

        // 3 Iterator
        Iterator<String> iterator = fruits.iterator();
        if (iterator.hasNext()) {
            do {
                System.out.println(iterator.next());
            } while (iterator.hasNext());
        }

        // 4 ListIterator
        ListIterator<String> listIterator = fruits.listIterator();
        if (listIterator.hasNext()) {
            do {
                System.out.println(listIterator.next());
            } while (listIterator.hasNext());
        }

        List<String> listWord = new ArrayList<>();
        listWord.add("Apple");
        listWord.add("Banana");
        listWord.add("Orange");

        // addAll
        fruits.addAll(listWord);

        for (String arr : fruits) {
            System.out.println("Fruits: " + arr);
        }
        // truy cập - elementAt
        List<Integer> listInteger = new LinkedList<>();

        listInteger.add(1);
        listInteger.add(8);
        listInteger.add(9);
        listInteger.add(0);
        listInteger.add(32);
        listInteger.add(9);
        listInteger.add(3);
        listInteger.add(32);
        listInteger.add(12);

        System.out.println("Index 2: " + listInteger.get(2));
        System.out.println("Index value 8:" + listInteger.indexOf(8));

        // remove
        listInteger.remove(2);
        System.out.println("List Integer after remove index 2: ");
        for (int arr : listInteger) {
            System.out.println("List Integer: " + arr);
        }

        // find
        if (fruits.contains("Apple")) {
            System.out.println("Apple is in the list");
        } else {
            System.out.println("Apple is not in the list");
        }

        if (listInteger.contains(8)) {
            System.out.println("8 is in the list");
        } else {
            System.out.println("8 is not in the list");
        }

        // find first and last
        int indexFirst = listInteger.indexOf(9);
        int indexLast = listInteger.lastIndexOf(32);
        System.out.println("Index first 9: " + indexFirst);
        System.out.println("Index last 32: " + indexLast);

        // arrange - sắp xếp
        Collections.sort(listInteger);
        System.out.println("List Integer after sort: ");
        for (int arr : listInteger) {
            System.out.println("List Integer: " + arr);
        }

        // reverse - đảo ngược
        Collections.reverse(listInteger);
        System.out.println("List Integer after reverse: ");
        for (int arr : listInteger) {
            System.out.println("List Integer: " + arr);
        }

        // shuffle - hoán vị
        Collections.shuffle(listInteger);
        System.out.println("List Integer after shuffle: ");
        for (int arr : listInteger) {
            System.out.println("List Integer: " + arr);
        }
    }
}
