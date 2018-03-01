package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        String data;
        while (fr.ready()) {
            data = fr.readLine();
            String key = data.split(" ")[0];
            double value = Double.parseDouble(data.split(" ")[1]);
            if (map.containsKey(data.split(" ")[0])) {
                map.put(key, value + map.get(key));
            } else {
                map.put(key, value);
            }
        }
        fr.close();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.printf("%s %s%s", entry.getKey(), entry.getValue(), System.lineSeparator());
        }
    }
}
