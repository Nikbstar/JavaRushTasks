package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> mamaMilaRamu = new ArrayList<>();
        Collections.addAll(mamaMilaRamu, "мама", "мыла", "раму");
        for (int i = 0; i < 3; i++) {
            mamaMilaRamu.add(3 - i, "именно");
        }
        for (String s : mamaMilaRamu) {
            System.out.println(s);
        }
    }
}
