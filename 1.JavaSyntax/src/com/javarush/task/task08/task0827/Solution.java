package com.javarush.task.task08.task0827;

import java.util.Date;
import java.time.LocalDate;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2020"));
//        System.out.println(isDateOdd("MAY 1 2013"));
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
    }

    public static boolean isDateOdd(String date) {
        Date d = new Date(date);
        d.setSeconds(0);
        d.setMinutes(0);
        d.setHours(0);
        d.setDate(1);
        d.setMonth(0);

        Date current = new Date(date);
        long msDistance = current.getTime() - d.getTime();
        int dayCount = (int) (msDistance / (1000 * 60 * 60 * 24));
        return dayCount % 2 == 0;
    }
}
