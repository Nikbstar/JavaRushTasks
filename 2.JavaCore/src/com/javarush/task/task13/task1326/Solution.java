package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        ArrayList<Integer> intsFromFile = new ArrayList<>();
        String data;
        while ((data = fis.readLine()) != null) {
            intsFromFile.add(Integer.parseInt(data));
        }

        fis.close();
        reader.close();

        Collections.sort(intsFromFile);
        for (Integer integer : intsFromFile) {
            if (integer % 2 == 0) {
                System.out.println(integer);
            }
        }
    }
}
