package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StringBuffer sb = new StringBuffer();
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        sb.append(ste.getClassName()).append(": ").append(ste.getMethodName()).append(": ").append(s);
        System.out.println(sb.toString());

    }
}
