package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, byte[]> buffer = new TreeMap<>();
        String fileName;
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) {
                break;
            }
            FileInputStream fis = new FileInputStream(fileName);
            if (fis.available() > 0) {
                byte[] values = new byte[fis.available()];
                fis.read(values);
                buffer.put(fileName, values);
            }
            fis.close();
        }
        reader.close();
        String fosName = buffer.firstKey();
        FileOutputStream fos = new FileOutputStream(fosName.substring(0, fosName.lastIndexOf(".part")));
        for (Map.Entry<String, byte[]> entry : buffer.entrySet()) {
            fos.write(entry.getValue());
        }
        fos.close();
    }
}
