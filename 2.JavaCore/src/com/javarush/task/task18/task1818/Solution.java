package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());
        reader.close();
        byte[] data = new byte[file2.available()];
        while(file2.available() > 0) {
            file2.read(data);
            file1.write(data);
        }
        file2.close();
        data = new byte[file3.available()];
        while(file3.available() > 0) {
            file3.read(data);
            file1.write(data);
        }
        file3.close();
        file1.close();
    }
}
