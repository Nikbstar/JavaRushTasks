package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] nums = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(reader.readLine());
        }
        if (nums[0] == nums[1]) {
            if (nums[1] != nums[2]) {
                System.out.println(3);
            }
        } else {
            if (nums[0] == nums[2]) {
                System.out.println(2);
            } else {
                if (nums[1] == nums[2]) {
                    System.out.println(1);
                }
            }
        }

    }
}
