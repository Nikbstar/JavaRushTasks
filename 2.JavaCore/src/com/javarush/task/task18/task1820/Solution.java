package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder tmp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        reader.close();
        while (fis.available() > 0) {
            int data = fis.read();
            if (data == ' ') {
                if (tmp.length() > 0) {
                    result.append(Math.round(Double.parseDouble(tmp.toString()))).append(" ");
                    tmp.delete(0, tmp.length());
                }
            } else {
                tmp.append((char) data);
                if (fis.available() == 0) {
                    result.append(Math.round(Double.parseDouble(tmp.toString())));
                }
            }
        }
        fis.close();
        fos.write(result.toString().getBytes());
        fos.close();
    }
}
