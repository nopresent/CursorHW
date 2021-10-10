package com.cursorhw.hw6;

import java.util.ArrayList;

public class TwoArrays {

    public static void main(String[] args) {

        ArrayList<Number> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(4);
        arrayList1.add(6);

        ArrayList<Number> arrayList2 = new ArrayList<>();
        arrayList2.add(6);
        arrayList2.add(5);
        arrayList2.add(10);
        arrayList2.add(1);

        System.out.println("ArrayList1: " + arrayList1);

        arrayList1.retainAll(arrayList2);

        System.out.println("ArrayList2: " + arrayList2);
        if (arrayList1.size() > 0) {
            System.out.println("Array's have a " + arrayList1.size() + " similar elements: " + arrayList1);
        } else {
            System.out.println("Array's do not have a similar elements.");
        }

    }

}

