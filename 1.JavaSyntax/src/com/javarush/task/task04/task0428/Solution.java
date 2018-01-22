package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[3];
        int checker = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(reader.readLine());
            if (nums[i] > 0) {
                checker++;
            }
        }
        System.out.println(checker);
    }
}
