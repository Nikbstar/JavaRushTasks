package com.javarush.task.task08.task0821;

import java.util.Map;
import java.util.HashMap;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> humans = new HashMap<>();

        humans.put("Коткин", "Николай");
        humans.put("Коткин", "Дмитрий");
        humans.put("Коткина", "Валентина");
        humans.put("Фоминых", "Ксения");
        humans.put("Коткина", "Ксения");
        humans.put("Грицко", "Дмитрий");
        humans.put("Попова", "Соня");
        humans.put("Фоминых", "Екатерина");
        humans.put("Копалов", "Павел");
        humans.put("Рожков", "Павел");

        return humans;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
