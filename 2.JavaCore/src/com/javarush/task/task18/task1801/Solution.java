package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        int result = 0;
        while (fis.available() > 0) {
            int data = fis.read();
            if (data > result) {
                result = data;
            }
        }
        fis.close();
        System.out.println(result);
    }
}
