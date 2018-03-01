package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        testString.printSomething();
        System.setOut(consoleStream);
        String[] nums = baos.toString().split(" +");
        System.out.printf("%s %d", baos.toString().trim(), calc(Integer.parseInt(nums[0]), Integer.parseInt(nums[2]), nums[1]));
    }

    public static int calc(int a, int b, String operation) {
        int result = 0;
        if ("+".equals(operation)) {
            result = a + b;
        } else if ("-".equals(operation)) {
            result = a - b;
        } else if ("*".equals(operation)) {
            result = a * b;
        }
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

