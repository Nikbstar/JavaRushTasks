package com.javarush.task.task10.task1019;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id;
        String name;
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            try {
                id = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                break;
            }
            name = reader.readLine();
            map.put(name, id);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.printf("%s %s%s", pair.getValue(), pair.getKey(), System.lineSeparator());
        }
    }
}
