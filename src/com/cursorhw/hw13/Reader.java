package com.cursorhw.hw13;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Reader {
     public static void main(String[] args) {

         File file = new File("file.txt");

        try (PrintWriter fw = new PrintWriter("file.txt");
             FileReader fr = new FileReader("file.txt")) {
            fw.println("Привет!");
            fw.println("Привет!");
            fw.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода данных");
        }
    }
}
