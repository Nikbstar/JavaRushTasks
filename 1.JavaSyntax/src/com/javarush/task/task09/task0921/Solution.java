package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
            try {
                while (true) {
                    nums.add(Integer.parseInt(reader.readLine()));
                }
            } catch (IOException ioe) {
            } catch (NumberFormatException nfe) {
                for (Integer num : nums) {
                    System.out.println(num);
                }
            }
    }
}
