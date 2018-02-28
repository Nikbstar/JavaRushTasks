package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine()).append(System.lineSeparator());
        }
        fileReader.close();
        String[] strings = sb.toString().split("\\W+");
        int count = 0;
        for (String string : strings) {
            if ("world".equals(string)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
