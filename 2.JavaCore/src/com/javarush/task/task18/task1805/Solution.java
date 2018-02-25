package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.TreeSet;
/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        TreeSet<Integer> bytes = new TreeSet<>();
        while (fis.available() > 0) {
            bytes.add(fis.read());
        }
        fis.close();
        for (Integer aByte : bytes) {
            System.out.printf("%d ", aByte);
        }
        System.out.println();
    }
}
