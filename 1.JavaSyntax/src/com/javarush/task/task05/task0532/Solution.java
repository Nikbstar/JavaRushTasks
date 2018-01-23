package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int tmp;
        int n = Integer.parseInt(reader.readLine());

        //напишите тут ваш код
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(reader.readLine());
            if (i == 0) {
                maximum = tmp;
            }
            if (tmp > maximum) {
                maximum = tmp;
            }
        }

        System.out.println(maximum);
    }
}
