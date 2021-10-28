package com.cursorhw.hw13;

import java.io.IOException;
import java.io.PrintWriter;

public class Reader {
     public static void main(String[] args) throws IOException {

        PrintWriter fw = new PrintWriter("file.txt");

        fw.println("Привет!");

        fw.flush();
        fw.close();

    }
}
