package com.cursorhw.hw6;

import java.util.ArrayList;

public class TwoDifferentArrays {

    public static void main(String[] args) {

        ArrayList<Number> arrayList1 = new ArrayList<>();
        // arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(4);
        arrayList1.add(6);

        ArrayList<String> arrayList2 = new ArrayList<>();
        // arrayList2.add("6");
        arrayList2.add("5");
        arrayList2.add("10");
        arrayList2.add("1");

        ArrayList<String> a1 = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            a1.add(String.valueOf(arrayList1.get(i)));
        }

        ArrayList<String> a2 = new ArrayList<>();
        for (int i = 0; i < arrayList2.size(); i++) {
            a2.add(String.valueOf(arrayList2.get(i)));
        }

        System.out.println("ArrayList1: " + a1);

        a1.retainAll(a2);

        System.out.println("ArrayList2: " + a2);
        if (a1.size() > 0) {
            System.out.println("Array's have a " + a1.size() + " similar elements: " + a1);
        } else {
            System.out.println("Array's do not have a similar elements.");
        }

    }
}
