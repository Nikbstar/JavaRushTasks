package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available() > 0) {
            int data = fis.read();
            if ((data >= 'a' && data <= 'z') || (data >= 'A' && data <= 'Z')) {
                count++;
            }
        }
        fis.close();
        System.out.println(count);
    }
}
