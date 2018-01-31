package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        ArrayList<Character> strVowels = new ArrayList<>();
        ArrayList<Character> strConsonants = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                strVowels.add(str.charAt(i));
            } else {
                strConsonants.add(str.charAt(i));
            }
        }
        for (Character strVowel : strVowels) {
            System.out.printf("%s ", strVowel);
        }
        System.out.println();
        for (Character strConsonant : strConsonants) {
            if (strConsonant != ' ') {
                System.out.printf("%s ", strConsonant);
            }
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}