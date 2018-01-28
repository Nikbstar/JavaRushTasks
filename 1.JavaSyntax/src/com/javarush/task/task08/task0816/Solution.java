package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        //напишите тут ваш код
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Name1", new Date("JANUARY 1 1980"));
        map.put("Name2", new Date("FEBRUARY 1 1980"));
        map.put("Name3", new Date("MARCH 1 1980"));
        map.put("Name4", new Date("APRIL 1 1980"));
        map.put("Name5", new Date("MAY 1 1980"));
        map.put("Name6", new Date("JULY 1 1980"));
        map.put("Name7", new Date("AUGUST 1 1980"));
        map.put("Name8", new Date("SEPTEMBER 1 1980"));
        map.put("Name9", new Date("OCTOBER 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            if (entry.getValue().getMonth() == 5 ||
                    entry.getValue().getMonth() == 6 ||
                    entry.getValue().getMonth() == 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
