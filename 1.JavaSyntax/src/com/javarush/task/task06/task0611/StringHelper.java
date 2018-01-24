package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static String multiply(String s, int count) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

    }
}
