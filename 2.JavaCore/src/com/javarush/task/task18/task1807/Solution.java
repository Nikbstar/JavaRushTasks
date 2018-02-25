package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        final byte SYMBOL = ',';
        int count = 0;
        while (fis.available() > 0) {
            if (fis.read() == SYMBOL) {
                count++;
            }
        }
        fis.close();
        System.out.println(count);
    }
}
