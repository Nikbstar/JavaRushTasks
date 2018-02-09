package com.javarush.task.task14.task1419;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
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
        try {
            float i = 1 / 0;

        } catch (ArithmeticException ae) {
            exceptions.add(ae);
        }

        //напишите тут ваш код
        try {
            int[] array = new int[-1];
        } catch (NegativeArraySizeException nase) {
            exceptions.add(nase);
        }
        try {
            int[] arr = new int[1];
            arr[1] = 1;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            exceptions.add(aioobe);
        }
        try {
            new FileReader("aaa.txt");
        } catch (FileNotFoundException fnfe) {
            exceptions.add(fnfe);
        }
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException npe) {
            exceptions.add(npe);
        }
        try {
            int a = Integer.parseInt("a");
        } catch (NumberFormatException nfe) {
            exceptions.add(nfe);
        }
        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (ClassCastException cce) {
            exceptions.add(cce);
        }
        try {
            String aa = "1";
            aa.charAt(3);
        } catch (StringIndexOutOfBoundsException sioobe) {
            exceptions.add(sioobe);
        }
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException ase) {
            exceptions.add(ase);
        }
        try {
            HashSet<String> set = new HashSet<>();
            set.add("sdff");
            set.add("flkw");
            for (String s : set) {
                set.remove(s);
            }
        } catch (ConcurrentModificationException cme) {
            exceptions.add(cme);
        }
    }
}
