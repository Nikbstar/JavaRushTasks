package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        int result = 0;
        int iterator = 0;
        while (input != -1) {
            result += input;
            input = Integer.valueOf(reader.readLine());
            iterator++;
        }
        iterator--;
        System.out.println((double) result / iterator);
    }
}

