package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        fr.close();
        ArrayList<String> names = new ArrayList<>();
        double max = 0d;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                names.clear();
                names.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                names.add(entry.getKey());
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
