package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.valueOf(reader.readLine());
        int days = 365;
        if (year % 4 == 0) {
            days = 366;
            if (year % 100 == 0) {
                days = 365;
                if (year % 400 == 0) {
                    days = 366;
                }
            }
        }
        System.out.printf("количество дней в году: %s", days);
    }
}