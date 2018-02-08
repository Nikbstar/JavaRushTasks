package com.javarush.task.task13.task1318;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;

/*
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = new FileInputStream(reader.readLine());
        while (is.available() > 0) {
            System.out.print((char) is.read());
        }
        is.close();
        reader.close();
    }
}