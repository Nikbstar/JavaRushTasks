package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> doubleTriple = new ArrayList<>();
        for (String s : list) {
            if (s.length() % 2 == 0) {
                doubleTriple.add(String.format("%s %s", s, s));
            } else {
                doubleTriple.add(String.format("%s %s %s", s, s, s));
            }
        }

        for (int i = 0; i < doubleTriple.size(); i++) {
            System.out.println(doubleTriple.get(i));
        }
    }
}
