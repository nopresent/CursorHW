package com.cursorhw.hw6;

import java.util.ArrayList;

public class Fruits {

    public static void main(String[] args) {

        ArrayList<String> arrayListFruits = new ArrayList<>();

        arrayListFruits.add("Orange");
        arrayListFruits.add("Apple");
        arrayListFruits.add("Lemon");
        arrayListFruits.add("Mango");

        System.out.println("***");
        System.out.println("Full ArrayList of Fruits: " + arrayListFruits);

        boolean replaceState = false;
        for (int i = 0; i < arrayListFruits.size(); i++) {
            if (arrayListFruits.get(i) == "Orange") {
                arrayListFruits.set(i, "Grapefruit");
                replaceState = true;
            }
        }

        if (replaceState == true) {
            System.out.println("ArrayList with replace string: " + arrayListFruits);
        } else {
            System.out.println("Orange is not in the array");
        }

        System.out.println("***");

    }

}
