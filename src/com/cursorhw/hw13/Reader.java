package com.cursorhw.hw13;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Reader {
     public static void main(String[] fileNames) {

         // Безопасно открываем поток
        try (PrintWriter fwIn = new PrintWriter(fileNames[0]);
             FileReader frIn = new FileReader(fileNames[0]);
             PrintWriter fwOut = new PrintWriter(fileNames[1])) {

            // Записали в файл
            fwIn.println("Write a main program that copies a given text file into another file using SimpleReader \n" +
                    "to read the input file and SimpleWriter to write the output file. The names of the input text \n" +
                    "file to be copied and of the destination file where the copy is to be saved are provided as \n" +
                    "command-line arguments. Assume that appropriate arguments will be provided and no error \n" +
                    "checking is necessary. The command-line arguments are accessible by your main program through \n" +
                    "the String[] args array parameter to the main method.\n");
            // Закрыли поток
            fwIn.close();

            // Вычитываем посимвольно из одного файла, записываем во второй
            int c;
            while ((c = frIn.read()) != -1) {
                fwOut.append((char)c);
            }

            // Закрыли поток
            fwOut.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода данных");
        }
    }

}
 
