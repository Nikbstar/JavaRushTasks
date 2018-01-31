package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        StackTraceElement[] ste = method1();
        for (StackTraceElement stackTraceElement : ste) {
            System.out.println(stackTraceElement);
        }
    }

    public static StackTraceElement[] method1() {
        method2();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method2() {
        method3();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method3() {
        method4();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method4() {
        StackTraceElement[] ste = method5();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method5() {
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace();
    }
}
