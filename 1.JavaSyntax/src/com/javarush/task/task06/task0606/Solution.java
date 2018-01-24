package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            if (Integer.parseInt(input[i]) % 2 == 0) {
                Solution.even++;
            } else {
                Solution.odd++;
            }
        }
        System.out.printf("Even: %s Odd: %s", Solution.even, Solution.odd);
    }
}
