package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileOutputStream fileOneFOS = new FileOutputStream(file1, true);
        FileInputStream fileOneFIS = new FileInputStream(file1);
        FileInputStream fileTwo = new FileInputStream(file2);
        byte[] buffer = new byte[fileOneFIS.available()];
        while (fileOneFIS.available() > 0) {
            fileOneFIS.read(buffer);
        }
        fileOneFIS.close();
        while (fileTwo.available() > 0) {
            fileOneFOS.write(fileTwo.read());
        }
        fileTwo.close();
        fileOneFOS.write(buffer);
        fileOneFOS.close();
    }
}
