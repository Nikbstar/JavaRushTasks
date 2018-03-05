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
            sb.append(fr.readLine()).append("");
        }
        fr.close();
        List<String> strings = new ArrayList<>();
        String str = sb.toString();
        str = str.replaceAll(" +", " ");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                try {
                    strings.add(findTag(str.substring(i), args[0]));
                } catch (WrongTagException wte) {
                }
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
    private static String findTag(String str, String tag) throws WrongTagException {
        StringBuilder sb = new StringBuilder();
        String firstTag = String.format("<%s", tag);
        String lastTag = String.format("</%s>", tag);
        sb.append(firstTag);
        if (!str.startsWith(firstTag)) {
            throw new WrongTagException();
        }
        for (int i = 0 + firstTag.length(); i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                if (endTag(str.substring(i), lastTag)) {
                    sb.append(lastTag);
                    break;
                }
                try {
                    String tmp = findTag(str.substring(i), tag);
                    sb.append(tmp);
                    i += tmp.length() - 1;
                } catch (WrongTagException wte) {
                    sb.append(str.charAt(i));
                }
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    private static boolean endTag(String str, String lastTag) {
        boolean result = false;
        if (str.startsWith(lastTag)) {
            result = true;
        }
        return result;
    }
}
