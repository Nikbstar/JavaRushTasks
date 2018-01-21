package com.javarush.task.task02.task0205;

/* 
Прибавка к зарплате
*/
public class Solution {
    public static void main(String[] args) {
        salary(700);
    }

    public static void salary(int a) {
        //напишите тут ваш код
        a += 100;
        System.out.printf("Твоя зарплата составляет: %s долларов в месяц.", a);
    }
}
