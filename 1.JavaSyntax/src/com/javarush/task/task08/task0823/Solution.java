package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        StringBuffer sb = new StringBuffer();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                sb.append(" ");
            } else {
                sb.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
