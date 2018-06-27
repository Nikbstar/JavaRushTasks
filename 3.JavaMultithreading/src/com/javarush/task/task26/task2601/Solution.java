package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana = getMediana(array);
        Arrays.sort(array, (o1, o2) -> {
            int m1 = Math.abs(mediana - o1);
            int m2 = Math.abs(mediana - o2);
            int result = m1 - m2;
            if (result == 0) {
                result = o1 - o2;
            }
            return result;
        });
        return array;
    }

    private static int getMediana(Integer[] array) {
        int result;
        int med = array.length / 2;
        Arrays.sort(array);
        result = array[med];
        if (array.length % 2 == 0) {
            result = (result + array[med - 1]) / 2;
        }
        return result;
    }
}
