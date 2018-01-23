package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    private static int DEFAULT_WEIGHT = 2;
    private static int DEFAULT_AGE = 1;
    private static String DEFAULT_COLOR = "Red";

    private void initialize(String name, int age, int weight, String address, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public void initialize(String name) {
        this.initialize(name, DEFAULT_AGE, DEFAULT_WEIGHT, null, DEFAULT_COLOR);
    }

    public void initialize(String name, int weight, int age) {
        this.initialize(name, age, weight, null, DEFAULT_COLOR);
    }

    public void initialize(String name, int age) {
        this.initialize(name, age, DEFAULT_WEIGHT, null, DEFAULT_COLOR);
    }

    public void initialize(int weight, String color) {
        this.initialize(null, DEFAULT_AGE, weight, null, color);
    }

    public void initialize(int weight, String color, String address) {
        this.initialize(null, DEFAULT_AGE, weight, address, color);
    }

    public static void main(String[] args) {

    }
}
