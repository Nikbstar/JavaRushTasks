package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        if (args[0].equals("-e")) {
            while (fis.available() > 0) {
                fos.write(intToByte(fis.read() + 1));
            }

        } else if (args[0].equals("-d")) {
            while (fis.available() > 0) {
                fos.write(intToByte(fis.read() - 1));
            }
        }
        fis.close();
        fos.close();
    }

    private static int intToByte (int value) {
        if (value < 0) {
            value = 255;
        }
        if (value > 255) {
            value = 0;
        }
        return value;
    }

}
