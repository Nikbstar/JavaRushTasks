package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        boolean isSort = true;
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int stringLength = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < stringLength) {
                System.out.println(i);
                break;
            }
            stringLength = strings.get(i).length();
        }
    }
}

