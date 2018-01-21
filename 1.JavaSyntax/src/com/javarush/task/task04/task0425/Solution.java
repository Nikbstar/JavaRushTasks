package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.valueOf(reader.readLine());
        int y = Integer.valueOf(reader.readLine());
        if (x > 0) {
            System.out.println((y > 0) ? 1 : 4);
        } else {
            System.out.println((y > 0) ? 2 : 3);
        }
    }
}
