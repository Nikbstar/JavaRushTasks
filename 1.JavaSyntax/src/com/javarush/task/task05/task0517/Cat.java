package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    private static final int DEFAULT_AGE = 1;
    private static final int DEFAULT_WEIGHT = 2;
    private static final String DEFAULT_COLOR = "Red";

    private Cat(String name, int age, int weight, String address, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public Cat(String name) {
        this(name, DEFAULT_AGE, DEFAULT_WEIGHT, null, DEFAULT_COLOR);
    }

    public Cat(String name, int weight, int age) {
        this(name, age, weight, null, DEFAULT_COLOR);
    }

    public Cat(String name, int age) {
        this(name, age, DEFAULT_WEIGHT, null, DEFAULT_COLOR);
    }

    public Cat(int weight, String color) {
        this(null, DEFAULT_AGE, weight, null, color);
    }

    public Cat(int weight, String color, String address) {
        this(null, DEFAULT_AGE, weight, address, color);
    }

    public static void main(String[] args) {

    }
}
