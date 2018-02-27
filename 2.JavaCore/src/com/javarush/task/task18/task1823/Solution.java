package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            int[] bytes = new int[256];
            try (FileInputStream fis = new FileInputStream(this.fileName)) {
                while (fis.available() > 0) {
                    bytes[fis.read()]++;
                }
                Solution.resultMap.put(this.fileName, maxByte(bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private int maxByte(int[] bytes) {
            int result = -1;
            int max = 0;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > max) {
                    max = bytes[i];
                    result = i;
                }
            }
            return result;
        }
    }
}
