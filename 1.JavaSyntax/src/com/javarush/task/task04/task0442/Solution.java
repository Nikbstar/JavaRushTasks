package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int rez = 0;
        while (i != -1) {
            i = Integer.valueOf(reader.readLine());
            rez += i;
        }
        System.out.println(rez);
    }
}
