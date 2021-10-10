package com.cursorhw.hw5;

public class Main {

    public static void main(String[] args) {

        System.out.println("1.");

        MyList myList = new MyList();
        myList.add(4);
        myList.add(2);
        myList.add(1231232123);

        System.out.println("PrintArr: " + myList.getArrayList());
        System.out.println("Min: " + myList.smallest());
        System.out.println("Max: " + myList.largest());

    }

}
