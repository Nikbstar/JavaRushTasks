package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double min = Double.valueOf(reader.readLine());
        if (((int) min - 3) % 5 == 0) {
            System.out.println("жёлтый");
        } else if (((int) min - 4) % 5 == 0) {
            System.out.println("красный");
        } else {
            System.out.println("зелёный");
        }
    }
}