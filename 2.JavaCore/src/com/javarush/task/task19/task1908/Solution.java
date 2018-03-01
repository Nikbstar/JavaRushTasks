package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        String data;
        while(fr.ready()) {
            data = fr.readLine();
            String[] digits = data.split(" ");
            for (String digit : digits) {
                if (digit.matches("\\b\\d+\\b")) {
                    fw.write(String.format("%s ", digit));
                }
            }
            fw.newLine();
        }
        fr.close();
        fw.close();
    }
}
