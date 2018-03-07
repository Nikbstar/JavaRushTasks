package com.javarush.task.task20.task2009;

/* 
Как сериализовать static?
*/

import java.io.Serializable;

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {

    }
}
