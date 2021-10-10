package com.cursorhw.hw2;

public class SystemCore {

    // Номер вопроса
    public static int count;

    // Разделитель вопросов
    public static String stringDelimiter = "---------";

    // Выводим в консоль вопрос-ответ
    static void printQuestionAnswer(String Question, String Answer) {
        if (count == 0) System.out.println(stringDelimiter);
        System.out.println(++count + ". " + Question);
        System.out.println(Answer);
        System.out.println(stringDelimiter);
    }

    // Сумма положительных чисел в массиве
    public static int sumPositiveArray(int[] Array) {
        int sumPositive = 0;
        for (int j : Array) {
            if (j > 0)
                sumPositive += j;
        }
        return sumPositive;
    }


    public static int[] replaceDuplicateForUsers(int[] Array) {

        // Удаляем дубликаты из массива
        // Для простоты использования сюда передаётся сам массив
        // Дальше вызывается метод replaceDuplicate с нужными параметрами

        return replaceDuplicate(Array, 0, 1);
    }

    public static int[] replaceDuplicate(int[] Array, int compareIndex, int startIndex) {

        //  Array - массив для анализа
        // compareIndex - Индекс елемента, значение из которого будем сравнивать
        // startIndex - Индекс елемента с которого будем начинать прогон массива

        for (int i = startIndex; i < Array.length; i++) {
            if (Array[compareIndex] == Array[i]) {
                Array[i] = 0;
            }
        }

        if (++compareIndex > Array.length) {
            return Array;
        } else {
            replaceDuplicate(Array, compareIndex, ++startIndex);
        }

        return Array;
    }
}
