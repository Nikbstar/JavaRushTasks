package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution.strings = new ArrayList<>();
        int maxStringLength = 0;
        for (int i = 0; i < 5; i++) {
            Solution.strings.add(reader.readLine());
            if (Solution.strings.get(i).length() > maxStringLength) {
                maxStringLength = Solution.strings.get(i).length();
            }
        }
        for (String s : strings) {
            if (s.length() == maxStringLength) {
                System.out.println(s);
            }
        }
    }
}
