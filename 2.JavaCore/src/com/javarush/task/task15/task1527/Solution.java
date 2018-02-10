package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        url = url.substring(url.indexOf('?') + 1);
        String[] params = url.split("&");
        int isObj = -1;
        for (int i = 0; i < params.length; i++) {
            System.out.printf("%s ", params[i].split("=")[0]);
            if (params[i].contains("obj=")) {
                isObj = i;
            }
        }
        System.out.println();

        if (isObj >= 0) {
            String value = params[isObj].split("=")[1];
            try {
                alert(Double.parseDouble(value));
            } catch (NumberFormatException nfe) {
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
