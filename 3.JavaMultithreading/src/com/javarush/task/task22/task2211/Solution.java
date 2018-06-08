package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);
        Charset w1251 = Charset.forName("Windows-1251");
        Charset u8 = Charset.forName("UTF-8");

         byte[] buffer = new byte[1000];
         inputStream.read(buffer);
         inputStream.close();
         String s = new String(buffer, w1251);
         buffer = s.getBytes(u8);
         outputStream.write(buffer);
         outputStream.close();

    }
}
