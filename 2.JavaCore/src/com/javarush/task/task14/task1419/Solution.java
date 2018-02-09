package com.javarush.task.task14.task1419;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        // 1
        try {
            float i = 1 / 0;

        } catch (ArithmeticException ae) {
            exceptions.add(ae);
        }

        //напишите тут ваш код
        // 2
        try {
            int[] arr = new int[1];
            arr[1] = 1;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            exceptions.add(aioobe);
        }
        // 3
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException npe) {
            exceptions.add(npe);
        }
        // 4
        try {
            int a = Integer.parseInt("a");
        } catch (NumberFormatException nfe) {
            exceptions.add(nfe);
        }
        // 5
        try {
            new FileReader("aaa.txt");
        } catch (FileNotFoundException fnfe) {
            exceptions.add(fnfe);
        }
        // 6
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException ase) {
            exceptions.add(ase);
        }
        // 7
        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (ClassCastException cce) {
            exceptions.add(cce);
        }
        // 8
        try {
            int[] array = new int[-1];
        } catch (NegativeArraySizeException nase) {
            exceptions.add(nase);
        }
        // 9

        // 10
    }
}
