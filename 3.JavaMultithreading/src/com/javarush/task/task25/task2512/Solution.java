package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> tList = new ArrayList<>();
        Throwable th = e;
        while (th != null) {
            tList.add(0, th);
            th = th.getCause();
        }
        for (Throwable throwable : tList) {
            System.out.println(throwable);
        }
    }

    public static void main(String[] args) {
    }
}
