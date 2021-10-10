package com.cursorhw.hw8;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Создали посетителя
        Visitor visitor = new Visitor();

        // Выдали ему книги
        visitor.tookAbook(LocalDate.of(2021, 10, 15), "Book 4");
        visitor.tookAbook(LocalDate.of(2021, 10, 1), "Book 2");
        visitor.tookAbook(LocalDate.of(2021, 10, 3), "Book 6");
        visitor.tookAbook(LocalDate.of(2021, 10, 15), "Book 5");
        visitor.tookAbook(LocalDate.of(2021, 10, 12), "Book 3");
        visitor.tookAbook(LocalDate.of(2021, 9, 29), "Book 1");

        System.out.println("1. Книги отсортированы в отчете по дате.");
        System.out.println(visitor.getReport());
        System.out.println("******");

        System.out.println("2. Сегодня " + LocalDate.now() + " книгу посетитель не брал.");
        System.out.println(visitor.searchTitleByDate(LocalDate.now()));
        System.out.println("******");

        System.out.println("3. 2021.10.03 - посетитель взял книгу.");
        System.out.println(visitor.searchTitleByDate(LocalDate.of(2021, 10, 3)));
        System.out.println("******");

        System.out.println("4. 2021.10.15 - посетитель взял несколько книг.");
        System.out.println(visitor.searchTitleByDate(LocalDate.of(2021, 10, 15)));
        System.out.println("******");

        System.out.println("5. Список дат, когда посетитель брал книги.");
        visitor.getDaysWithBook();
        System.out.println("******");

        System.out.println("6. Список книг, которые взял посетитель.");
        visitor.getListOfTheBook();
        System.out.println("******");

        System.out.println("7. Список книг для диапазона дат.");
        visitor.rangeOfDates(LocalDate.of(2021, 10, 11), LocalDate.of(2021, 10, 17));
        System.out.println("******");

    }

}


