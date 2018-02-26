package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int countSpaces = 0;
        int countAllSymbols = fis.available();
        int data;
        while(fis.available() > 0) {
            data = fis.read();
            if (data == ' ') {
                countSpaces++;
            }
        }
        fis.close();
        double result = (countSpaces * 100d) / countAllSymbols;
        System.out.printf("%.2f%s", result, System.lineSeparator());
    }
}
