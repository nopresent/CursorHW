package com.cursorhw.hw8;

import java.time.LocalDate;
import java.util.*;

public class Visitor extends LibraryVisitors {

    @Override
    public void tookAbook(LocalDate localDate, String titleOfTheBook) {
        HashMap<String, Integer> DayMap = new HashMap<>();
        DayMap.put("y", localDate.getYear());
        DayMap.put("m", localDate.getMonthValue());
        DayMap.put("d", localDate.getDayOfMonth());

        // Если в указанную дату не было книг, создаем новый мааси книг и добавляем туда книгу N1
        ArrayList<String> bookArray = new ArrayList<>();

        if (searchTitleByDate(localDate).get(0) != getNoBook()) {
            // Такой день уже есть, находим его и дописываем книгу
            TreeMap report = getReport();

            Set set = report.entrySet();
            Iterator iterator = set.iterator();

            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();  // {d=25, y=2021, m=9}=Book 1
                bookArray = (ArrayList<String>) entry.getValue();
            }
        }

        bookArray.add(titleOfTheBook);
        getReport().put(DayMap, bookArray);
    }

}

abstract class LibraryVisitors implements LibraryReport {

    private String noBook = "There are no books for this date";

    public String getNoBook() {
        return noBook;
    }

    /*
         report - для хранения дат и книг
         20211001 - DayMap
           Книга 1 - ArrayList
           Книга 2
         20211002
           Книга 1
       */
    private TreeMap<HashMap<String, Integer>, ArrayList<String>> report = new TreeMap<>(new Comparator<HashMap<String, Integer>>() {
        @Override
        public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
            return hashToLocalDate(o1).compareTo(hashToLocalDate(o2));
        }
    });

    public TreeMap<HashMap<String, Integer>, ArrayList<String>> getReport() {
        return report;
    }

    public LocalDate hashToLocalDate(HashMap<String, Integer> hashMap) {
        return LocalDate.of(hashMap.get("y"), hashMap.get("m"), hashMap.get("d"));
    }

    // Поиск книги по дате LocalDate
    public ArrayList searchTitleByDate(LocalDate localDate) {
        Set set = report.entrySet();
        Iterator iterator = set.iterator();
        ArrayList answer = new ArrayList();
        answer.add(noBook);

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();  // {d=25, y=2021, m=9}=Book 1
            HashMap<String, Integer> entryHm = (HashMap<String, Integer>) entry.getKey();
            if (localDate.equals(hashToLocalDate(entryHm))) {
                answer = (ArrayList) entry.getValue();
            }
        }
        return answer;
    }

    // Указать даты в которые брали книги
    public void getDaysWithBook() {
        Set set = report.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();  // {d=25, y=2021, m=9}=Book 1
            HashMap<String, Integer> entryHm = (HashMap<String, Integer>) entry.getKey();
            System.out.println(hashToLocalDate(entryHm));
        }
    }

    // Список книг для диапазона дат
    public void rangeOfDates(LocalDate time1, LocalDate time2) {
        // Опеределяем какая дата больше
        LocalDate dStart = time1;
        LocalDate dEnd = time2;
        if (time1.isAfter(time2)) {
            dStart = time2;
            dEnd = time1;
        }

        while (!dStart.equals(dEnd.plusDays(1))) {
            ArrayList<String> arrayBookTitle = searchTitleByDate(dStart);
            if (arrayBookTitle.get(0) == noBook) {
                System.out.println(dStart + " - 0");
            } else {
                System.out.println(dStart + " - " + arrayBookTitle.size());
            }
            dStart = dStart.plusDays(1);
        }
    }

    public void getListOfTheBook() {
        Set set = report.entrySet();
        Iterator iterator = set.iterator();
        ArrayList<String> arrayListOut = new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();  // {d=25, y=2021, m=9}=Book 1
            ArrayList<String> arrayListIn = (ArrayList<String>) entry.getValue();
            arrayListOut.addAll(arrayListIn);
        }
        System.out.println(arrayListOut);
    }

}
