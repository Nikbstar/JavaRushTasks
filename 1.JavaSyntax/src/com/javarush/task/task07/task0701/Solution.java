package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        System.out.println(Arrays.toString(array));
        int max = max(array);
        System.out.println(max);
        System.out.println(Arrays.toString(array));
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        return nums;
    }

//    public static int max(int[] array) {
//        // найди максимальное значение
//        int max = array[0];
//        for (int i : array) {
//            if (i > max) {
//                max = i;
//            }
//        }
//        return max;
//    }
    public static int max(int[] array) {
        Arrays.sort(array);
        return array[array.length-1];
    }
}
