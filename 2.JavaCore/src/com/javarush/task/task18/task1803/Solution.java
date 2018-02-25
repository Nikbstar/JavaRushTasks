package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Long> map = new HashMap<>();
        while (fis.available() > 0) {
            int data = fis.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1L);
            }
        }
        fis.close();
        ArrayList<Integer> result = new ArrayList<>();
        Long max = 0L;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result.clear();
                result.add(entry.getKey());
            } else if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
    }
}
