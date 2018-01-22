package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        if (num == 0) {
            System.out.println("ноль");
        } else {
            System.out.print((num > 0) ? "положительное " : "отрицательное ");
            System.out.println((num % 2 == 0) ? "четное число" : "нечетное число");
        }
    }
}
