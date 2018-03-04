package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();
        String data;
        while (fr.ready()) {
            data = fr.readLine();
            for (String str : data.split(" ")) {
                if (str.length() > 6) {
                    sb.append(str).append(',');
                }
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.toString().length() - 1);
            fw.write(sb.toString());
        }
        fr.close();
        fw.close();
    }
}
