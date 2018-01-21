package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.valueOf(reader.readLine());
        int num2 = Integer.valueOf(reader.readLine());
        int num3 = Integer.valueOf(reader.readLine());
        if (num1 == num2) {
            if (num2 == num3) {
                System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                System.out.println(num1 + " " + num2);
            }
        } else if (num2 == num3) {
            System.out.println(num2 + " " + num3);
        } else if (num1 == num3) {
            System.out.println(num1 + " " + num3);
        }
    }
}