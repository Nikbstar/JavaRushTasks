package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    private static BigInteger recfact(long start, long n) {
        long i;
        if (n <= 16) {
            BigInteger r = new BigInteger(String.valueOf(start));
            for (i = start + 1; i < start + n; i++) {
                r = r.multiply(BigInteger.valueOf(i));
            }
            return r;
        }
        i = n / 2;
        return recfact(start, i).multiply(recfact(start + i, n - i));
    }

    public static String factorial(int n) {
        //add your code here

        if (n >= 0) {
            return "" + recfact(1, n);
        }
        return "0";
    }
}
