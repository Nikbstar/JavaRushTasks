package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(1d, "11");
        labels.put(2d, "22");
        labels.put(3d, "33");
        labels.put(4d, "44");
        labels.put(5d, "55");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
