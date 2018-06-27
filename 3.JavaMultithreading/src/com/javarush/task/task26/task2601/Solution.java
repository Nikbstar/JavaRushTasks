package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array1 = {13,8,15,5,17};
        System.out.println(Arrays.toString(sort(array1)));

        Integer[] array2 = {8,15,5,17};
        System.out.println(Arrays.toString(sort(array2)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana = getMediana(array);

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
