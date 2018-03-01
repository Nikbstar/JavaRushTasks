package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            fw.write(data.replaceAll("\\p{Punct}", ""));
        }
        fr.close();
        fw.close();
    }
}
