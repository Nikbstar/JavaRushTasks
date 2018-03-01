package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        String data;
        while (fr.ready()) {
            data = fr.readLine();
            for (String str : data.split(" ")) {
                boolean isDig = false;
                boolean isLit = false;
                for (char ch : str.toCharArray()) {
                    if (ch >= '0' && ch <= '9') {
                        isDig = true;
                    } else {
                        isLit = true;
                    }
                }
                if (isDig && isLit) {
                    fw.write(String.format("%s ", str));
                }
            }
        }
        fr.close();
        fw.close();
    }
}
