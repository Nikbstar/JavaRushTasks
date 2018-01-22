package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        if (num > 0 && num < 1000) {
            System.out.print((num % 2 == 0) ? "четное " : "нечетное ");
            if (num < 10) {
                System.out.println("однозначное число");
            } else if (num > 99) {
                System.out.println("трехзначное число");
            } else {
                System.out.println("двузначное число");
            }
        }
    }
}
