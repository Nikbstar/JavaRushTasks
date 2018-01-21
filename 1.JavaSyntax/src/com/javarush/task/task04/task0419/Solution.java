package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.valueOf(reader.readLine());
        int num2 = Integer.valueOf(reader.readLine());
        int num3 = Integer.valueOf(reader.readLine());
        int num4 = Integer.valueOf(reader.readLine());
        System.out.println(max(max(num1, num2), max(num3, num4)));
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
