package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        try {
            String[] arr = string.split(" ");
            return String.format("%s %s %s %s", arr[1], arr[2], arr[3], arr[4]);
        } catch (Exception re) {
            throw new TooShortStringException();
        }

//        int firstSpace = string.indexOf(' ') + 1;
//        int lastSpace = firstSpace;
//        for (int i = 0; i < 4; i++) {
//            if (lastSpace == -1) {
//                throw new TooShortStringException();
//            }
//            lastSpace = string.indexOf(' ', lastSpace + 1);
//        }
//        if (lastSpace == -1) {
//            lastSpace = string.length();
//        }
//        return string.substring(firstSpace, lastSpace);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
