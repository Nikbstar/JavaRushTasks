package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean result = false;
        if (telNumber != null && !telNumber.isEmpty()) {
            int digitsCount = digits(telNumber);
            if (telNumber.charAt(0) == '+' && digitsCount == 12) {
                result = telNumber.matches("^\\+\\d+(\\(\\d{3}\\))?(-?\\d+-?)?\\d+$");
            } else  if (digitsCount == 10){
                result = telNumber.matches("(^\\d+(\\(\\d{3}\\))?)\\d*(\\-?\\d+\\-?)?\\d+$|^\\(\\d{3}\\)\\d*(\\-?\\d+\\-?)?\\d+$");
            }
        }
        return result;
    }

    private static int digits(String str) {
        String[] digits = str.split("\\D");
        int result = 0;
        for (String digit : digits) {
            result += digit.length();
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
