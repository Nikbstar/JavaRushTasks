package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static final long NUMBER = Long.MAX_VALUE;
    private static long[][] pows;

    public static long[] getNumbers(long N) {
        long[] result = null;
        //result = cheatMethod(N); // 9:60
        //result = badMethod(N); // 9:637324
        //result = acmpru(N); // 9:129
        result = armstrongNumbersMultiSetLongOpt(N); // 9:68
        return result;
    }

    // https://github.com/shamily/ArmstrongNumbers/blob/master/ArmstrongNumbersMultiSetLongOpt.java
    private static long[] armstrongNumbersMultiSetLongOpt(long N) {
        int pow = String.valueOf(N).length();
        List<Long> temp = ArmstrongNumbersMultiSetLongOpt.generate(pow);
        long[] result = new long[temp.size()];
        byte resultIterator = 0;
        for (Long aLong : temp) {
            result[resultIterator++] = aLong;
        }
        return result;
    }

    // My variant with help: https://acmp.ru/article.asp?id_text=198
    private static long[] acmpru(long N) {
        pows = new long[10][String.valueOf(N).length() + 1];
        for (int i = 0; i < pows.length; i++) {
            for (int j = 0; j < pows[i].length; j++) {
                if (i == 0) {
                    pows[i][j] = 0;
                } else {
                    pows[i][j] = power(i, j);
                }
            }
        }
        Set<Long> temp = new TreeSet<>();
        long pwSum;
        for (long iterator = 1; iterator < N; iterator = numGenerator(iterator)) {
            long tmp = iterator;
            while (tmp > 0 && tmp < N ) {
                pwSum = powSum(tmp);
                if (pwSum > 0 && pwSum < N && isArmstrongNumber(pwSum)) {
                    temp.add(pwSum);
                }
                tmp *= 10;
            }
        }
        long[] result = new long[temp.size()];
        byte resultIterator = 0;
        for (Long aLong : temp) {
            result[resultIterator++] = aLong;
        }
        return result;
    }
    private static long power(int num, int pow) {
        long result = 1;
        for (int i = 0; i < pow; i++) {
            result *= num;
        }
        return result;
    }
    private static boolean isArmstrongNumber(long num) {
        boolean result = false;
        if (num != 0 && num == powSum(num)) {
            result = true;
        }
        return result;
    }
    private static long powSum(long num) {
        int pow = String.valueOf(num).length();
        long tmp = num;
        long sum = 0;
        for (int i = 0; i < pow; i++) {
            sum += pows[(int) (tmp % 10)][pow];
            tmp /= 10;
        }
        return sum;
    }
    private static long numGenerator(long num) {
        num++;
        int iterator = 0;
        char[] str = String.valueOf(num).toCharArray();
        long result;
        if (str.length > 1) {
            while (iterator < str.length - 1) {
                if (str[iterator + 1] < str[iterator]) {
                    str[iterator + 1] = str[iterator];
                }
                iterator++;
            }
        }
        try {
            result = Long.parseLong(String.valueOf(str));
        } catch (NumberFormatException nfe) {
            result = Long.MAX_VALUE;
        }
        return result;
    }

    // For tests
    private static long[] cheatMethod(long N) {
        long[] numbers = new long[50];
        numbers[0] = 1L;
        numbers[1] = 2L;
        numbers[2] = 3L;
        numbers[3] = 4L;
        numbers[4] = 5L;
        numbers[5] = 6L;
        numbers[6] = 7L;
        numbers[7] = 8L;
        numbers[8] = 9L;
        numbers[9] = 153L;
        numbers[10] = 370L;
        numbers[11] = 371L;
        numbers[12] = 407L;
        numbers[13] = 1634L;
        numbers[14] = 8208L;
        numbers[15] = 9474L;
        numbers[16] = 54748L;
        numbers[17] = 92727L;
        numbers[18] = 93084L;
        numbers[19] = 548834L;
        numbers[20] = 1741725L;
        numbers[21] = 4210818L;
        numbers[22] = 9800817L;
        numbers[23] = 9926315L;
        numbers[24] = 24678050L;
        numbers[25] = 24678051L;
        numbers[26] = 88593477L;
        numbers[27] = 146511208L;
        numbers[28] = 472335975L;
        numbers[29] = 534494836L;
        numbers[30] = 912985153L;
        numbers[31] = 4679307774L;
        numbers[32] = 32164049650L;
        numbers[33] = 32164049651L;
        numbers[34] = 40028394225L;
        numbers[35] = 42678290603L;
        numbers[36] = 44708635679L;
        numbers[37] = 49388550606L;
        numbers[38] = 82693916578L;
        numbers[39] = 94204591914L;
        numbers[40] = 28116440335967L;
        numbers[41] = 4338281769391370L;
        numbers[42] = 4338281769391371L;
        numbers[43] = 21897142587612075L;
        numbers[44] = 35641594208964132L;
        numbers[45] = 35875699062250035L;
        numbers[46] = 1517841543307505039L;
        numbers[47] = 3289582984443187032L;
        numbers[48] = 4498128791164624869L;
        numbers[49] = 4929273885928088826L;
        int i;
        long[] tmp = new long[50];
        for (i = 0; i < numbers.length; i++) {
            if (numbers[i] >= N) {
                break;
            }
            tmp[i] = numbers[i];
        }
        return Arrays.copyOf(tmp, i);
    }

    // v lob (very slooooow)
    private static long[] badMethod(long N) {
        long[] temp = new long[50];
        int i = 0;
        for (long n = 1; n < N; n++) {
            String str = String.valueOf(n);
            int pow = str.length();
            long tmp = 0;
            for (int iterator = 0; iterator < pow; iterator++) {
                tmp += (int) Math.pow(Double.parseDouble(String.valueOf(str.charAt(iterator))), pow);
            }
            if (tmp == n) {
                temp[i++] = n;
            }
        }
        return Arrays.copyOf(temp, i);
    }

    public static void main(String[] args) {
        Date start = new Date();
        long[] res = getNumbers(NUMBER);
        for (long l : res) {
            System.out.println("arr: " + l);
        }
        Date finish = new Date();
        System.out.println("time: " + (finish.getTime() - start.getTime()));
        System.out.println("arr len: " + res.length);
    }
}
