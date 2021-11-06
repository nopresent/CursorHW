package com.cursorhw.hw16;

public class Main {
    public static void main(String[] args) {

        Table table = new Table();
        MyThread myThread = new MyThread("Thread1", table);
        MyThread myThread2 = new MyThread("Thread2", table);

        myThread.start();
        myThread2.start();


    }
}
