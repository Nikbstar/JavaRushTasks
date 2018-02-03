package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        int lastInt = -1;
        int lastStr = -1;
        for (int i = array.length; i >= 0; i--) {
            for (int iterator = 0; iterator < i; iterator++) {
                if (Solution.isNumber(array[iterator])) {
                    if (lastInt < 0) {
                        lastInt = iterator;
                        continue;
                    }
                    if (Integer.parseInt(array[iterator]) > Integer.parseInt(array[lastInt])) {
                        String tmp = array[iterator];
                        array[iterator] = array[lastInt];
                        array[lastInt] = tmp;
                    }
                    lastInt = iterator;
                } else {
                    if (lastStr < 0) {
                        lastStr = iterator;
                        continue;
                    }
                    if (Solution.isGreaterThan(array[lastStr], array[iterator])) {
                        String tmp = array[iterator];
                        array[iterator] = array[lastStr];
                        array[lastStr] = tmp;
                    }
                    lastStr = iterator;
                }
            }
            lastInt = -1;
            lastStr = -1;
        }
    }

//    private static boolean tryParseInt(String value) {
//        boolean result;
//        try {
//            Integer.parseInt(value);
//            result = true;
//        } catch (NumberFormatException nfe) {
//            result = false;
//        }
//        return result;
//    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
