package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    //напишите тут ваш код
    private String name;
    private int height;
    private String color;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int height) {
        this.initialize(name);
        this.height = height;
    }

    public void initialize(String name, int height, String color) {
        this.initialize(name, height);
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
