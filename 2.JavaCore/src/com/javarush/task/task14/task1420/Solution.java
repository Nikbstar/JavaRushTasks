package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = -1, b = -1;
        try {
            a = Integer.parseInt(reader.readLine());
            if (a <= 0) {
                throw new NumberFormatException();
            }
            b = Integer.parseInt(reader.readLine());
            if (b <= 0) {
                throw new NumberFormatException();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        int min = (a < b) ? a : b;
        int result = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        System.out.println(result);
    }
}
