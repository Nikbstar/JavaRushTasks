package com.javarush.task.task20.task2025;

import java.util.List;
import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> res = new ArrayList<>();
        for (long n = 1; n < N; n++) {
            String str = String.valueOf(n);
            int pow = str.length();
            long tmp = 0;
            for (int iterator = 0; iterator < pow; iterator++) {
                tmp += (int) Math.pow(Double.parseDouble(String.valueOf(str.charAt(iterator))), pow);
            }
            if (tmp == n) {
                res.add(n);
            }
        }
        result = new long[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        for (long l : getNumbers(99999999)) {
            System.out.println(l);
        }
    }
}
