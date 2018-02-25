package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer = new byte[file1.available()];
        if (file1.available() > 0) {
            file1.read(buffer);
            byte[] bufferTmp = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                bufferTmp[i] = buffer[buffer.length - i - 1];
            }
            file2.write(bufferTmp);
        }
        file1.close();
        file2.close();
    }
}
