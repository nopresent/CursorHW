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
        getReport().put(DayMap, titleOfTheBook);
    }
}

abstract class LibraryVisitors implements LibraryReport {

    private String noBook = "There are no books for this date";
    /*
     report - для хранения дат и книг
     20211001 - DayMap
       Книга 1 - ArrayList
       Книга 2
     20211002
       Книга 1
   */
    private TreeMap<HashMap<String, Integer>, String> report = new TreeMap<>(new Comparator<HashMap<String, Integer>>() {
        @Override
        public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
            LocalDate time1 = LocalDate.of(o1.get("y"), o1.get("m"), o1.get("d"));
            LocalDate time2 = LocalDate.of(o2.get("y"), o2.get("m"), o2.get("d"));
            return time1.compareTo(time2);
        }
    });

    public TreeMap<HashMap<String, Integer>, String> getReport() {
        return report;
    }

    public LocalDate hashToLocalDate(HashMap<String, Integer> hashMap) {
        return LocalDate.of(hashMap.get("y"), hashMap.get("m"), hashMap.get("d"));
    }

    // Поиск книги по дате LocalDate
    public String searchTitleByDate(LocalDate localDate) {
        Set set = report.entrySet();
        Iterator iterator = set.iterator();
        String answer = noBook;

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();  // {d=25, y=2021, m=9}=Book 1
            HashMap<String, Integer> entryHm = (HashMap<String, Integer>) entry.getKey();
            if (localDate.equals(hashToLocalDate(entryHm))) {
                answer = (String) entry.getValue();
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

        while (!dStart.equals(dEnd)) {
            dStart = dStart.plusDays(1);
            String bookTitle = searchTitleByDate(dStart);
            if (searchTitleByDate(dStart) == noBook) {
                bookTitle = "0";
            }
            System.out.println(dStart + " - " + bookTitle);
        }
    }

}
