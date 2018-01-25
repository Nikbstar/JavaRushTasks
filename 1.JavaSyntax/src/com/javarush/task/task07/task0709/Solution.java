package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        strings.add(reader.readLine());
        int minStringLength = strings.get(0).length();
        for (int i = 1; i < 5; i++) {
            strings.add(reader.readLine());
            if (strings.get(i).length() < minStringLength) {
                minStringLength = strings.get(i).length();
            }
        }
        for (String s : strings) {
            if (s.length() == minStringLength) {
                System.out.println(s);
            }
        }
    }
}
