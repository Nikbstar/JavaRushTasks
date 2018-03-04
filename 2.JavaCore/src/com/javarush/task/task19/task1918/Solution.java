package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();
        reader.close();
        while (fr.ready()) {
            sb.append(fr.readLine()).append(" ");
        }
        fr.close();
        List<String> strings = new ArrayList<>();
        String firstTag = String.format("<%s", args[0]);
        String lastTag = String.format("</%s>", args[0]);

    }
}
