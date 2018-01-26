package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] integers = new int[20];
        integers[0] = Integer.parseInt(reader.readLine());
        maximum = integers[0];
        minimum = integers[0];
        for (int i = 1; i < integers.length; i++) {
            integers[i] = Integer.parseInt(reader.readLine());
            if (integers[i] > maximum) {
                maximum = integers[i];
            }
            if (integers[i] < minimum) {
                minimum = integers[i];
            }
        }
        System.out.print(maximum);
        System.out.print(" ");
        System.out.println(minimum);
    }
}
