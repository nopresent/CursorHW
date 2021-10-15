package com.cursorhw.hw9;

public class testMyList {

    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        System.out.println("Добавили 3 елемента");
        list.add("123");
        list.add("456");
        list.add("789");

        System.out.println(list.toString());

        System.out.println("Добавили в массив елемент с индексом 4");
        list.add(4, "555");
        System.out.println(list.toString());

        System.out.println("Добавили в массив елемент с индексом 2, произошёл сдвиг");
        list.add(2, "WER");
        System.out.println(list.toString());

        System.out.print("Рамер массива: ");
        System.out.println(list.size());

        System.out.print("Получаем елемент с индексом 3: ");
        System.out.println(list.get(3));

        System.out.println("Удаляем елемент с индекосм 3");
        list.remove(3);
        System.out.println(list.toString());

        System.out.println("Показать елементы с 2 по 4 индекс");
        System.out.println(list.subList(2, 4));

        System.out.println("Удалить елемент, значение которого 456");
        list.remove("456");

        System.out.println("Напечатали массив");
        System.out.println(list.toString());


//        System.out.print("Чистим массив");
//        list.clear();
//        System.out.println(list.toString());


    }

}
