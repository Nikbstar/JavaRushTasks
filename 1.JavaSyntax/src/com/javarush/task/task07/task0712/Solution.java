package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        strings.add(reader.readLine());
        int minStringLength = strings.get(0).length();
        int maxStringLength = strings.get(0).length();
        for (int i = 1; i < 10; i++) {
            strings.add(reader.readLine());
            if (minStringLength > strings.get(i).length()) {
                minStringLength = strings.get(i).length();
            }
            if (maxStringLength < strings.get(i).length()) {
                maxStringLength = strings.get(i).length();
            }
        }
        for (String s : strings) {
            if (s.length() == minStringLength || s.length() == maxStringLength) {
                System.out.println(s);
                break;
            }
        }
    }
}
