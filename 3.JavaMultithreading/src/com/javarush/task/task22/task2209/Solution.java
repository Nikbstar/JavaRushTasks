package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fis = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while(fis.ready()) {
            sb.append(fis.readLine()).append(" ");
        }
        fis.close();
        sb.deleteCharAt(sb.length() - 1);
        String[] words = sb.toString().split(" ");
        Arrays.sort(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        String[] strings = Arrays.copyOf(words, words.length);
        int n = strings.length;
        String tmp;
        if (n != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!strings[i + 1].equals(strings[j]) && strings[i].charAt(strings[i].length() - 1) == strings[j].toLowerCase().charAt(0)) {
                        tmp = strings[i + 1];
                        strings[i + 1] = strings[j];
                        strings[j] = tmp;
                        break;
                    }
                }
            }
            for (String word : strings) {
                sb.append(word).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }
}
