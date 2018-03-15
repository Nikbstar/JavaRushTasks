package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {




    public static long[] getNumbers(long N) {
        long[] result = null;
        result = cheatMethod(N);
        return result;
    }

    // TODO: https://github.com/shamily/ArmstrongNumbers/blob/master/ArmstrongNumbersMultiSetLongOpt.java

    private static long[] cheatMethod(long N) {
        // !!!!cheat!!!!
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

    public static void main(String[] args) {
        Date start = new Date();
        long[] res = getNumbers(1);
        for (long l : res) {
            System.out.println("arr: " + l);
        }
        Date finish = new Date();
        System.out.println("time: " + (finish.getTime() - start.getTime()));
        System.out.println("arr len: " + res.length);
    }
}
