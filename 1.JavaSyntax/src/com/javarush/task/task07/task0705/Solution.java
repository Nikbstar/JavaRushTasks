package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intsBig = new int[20];
        for (int i = 0; i < intsBig.length; i++) {
            intsBig[i] = Integer.parseInt(reader.readLine());
        }
        int[] intsMini1 = new int[10];
        int[] intsMini2 = new int[10];
        for (int i = 0; i < intsBig.length; i++) {
            if (i < intsBig.length / 2) {
                intsMini1[i] = intsBig[i];
            } else {
                intsMini2[i - (intsBig.length / 2)] = intsBig[i];
                System.out.println(intsMini2[i - (intsBig.length / 2)]);
            }
        }
    }
}
