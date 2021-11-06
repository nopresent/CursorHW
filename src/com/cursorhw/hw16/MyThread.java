package com.cursorhw.hw16;

public class MyThread extends Thread {
    private String threadName;
    private Table table;
    private static int numb = 1;

    public MyThread(String threadName, Table table) {
        this.threadName = threadName;
        this.table = table;
    }

    @Override
    public void run() {
        synchronized (table) {
            while (numb <= 20) {
                table.notify();
                System.out.println(threadName + " - " + numb++);
                try {
                    table.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            table.notify();
        }
    }
}
