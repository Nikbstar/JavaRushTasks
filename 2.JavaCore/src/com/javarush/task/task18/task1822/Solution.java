package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String id = args[0];
        BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String data;
        while ((data = fis.readLine()) != null) {
            if (data.startsWith(id + " ")) {
                System.out.println(data);
                break;
            }
        }
        fis.close();
    }
}
