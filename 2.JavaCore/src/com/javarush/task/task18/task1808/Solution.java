package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer = new byte[(file1.available() + 1) / 2];
        if (file1.available() > 0) {
            int count = file1.read(buffer);
            file2.write(buffer, 0, count);
            count = file1.read(buffer);
            file3.write(buffer, 0, count);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
