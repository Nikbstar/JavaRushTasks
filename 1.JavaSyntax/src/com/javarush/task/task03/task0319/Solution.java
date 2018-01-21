package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String num1 = reader.readLine();
        String num2 = reader.readLine();
        System.out.printf("%s получает %s через %s лет.", name, num1, num2);
    }
}
