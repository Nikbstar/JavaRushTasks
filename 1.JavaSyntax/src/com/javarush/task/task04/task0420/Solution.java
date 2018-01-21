package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(reader.readLine());
        }
        Arrays.sort(nums);
        System.out.printf("%s %s %s", nums[2], nums[1], nums[0]);
    }
}
