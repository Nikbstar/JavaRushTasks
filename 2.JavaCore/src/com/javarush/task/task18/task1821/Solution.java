package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer, Long> result = new TreeMap<>();
        while (fis.available() > 0) {
            int data = fis.read();
            if (result.containsKey(data)) {
                result.put(data, result.get(data) + 1);
            } else {
                result.put(data, 1L);
            }
        }
        fis.close();

        for (Map.Entry<Integer, Long> entry : result.entrySet()) {
            System.out.printf("%c %d%s", entry.getKey(), entry.getValue(), System.lineSeparator());
        }
    }
}
