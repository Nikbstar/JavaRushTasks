package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private Human mother;
        private Human father;
        private String address;
        private boolean sex;

        public Human(String name, int age, Human mother, Human father, String address, boolean sex) {
            this.name = name;
            this.age = age;
            this.mother = mother;
            this.father = father;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, int age, Human mother, Human father, String address) {
            this(name, age, mother, father, address, false);
        }

        public Human(String name, int age, Human mother, Human father) {
            this(name, age, mother, father, "Home");
        }

        public Human(String name, int age, Human mother) {
            this(name, age, mother, new Human());
        }

        public Human(String name, int age) {
            this(name, age, new Human());
        }

        public Human(Human mother, Human father) {
            this("Ksusha", 12, mother, father);
        }

        public Human(String name) {
            this(name, 12);
        }

        public Human(int age) {
            this("Ksusha", age);
        }

        public Human(Human mother) {
            this("Ksusha", 12, mother);
        }

        public Human() {
            this("Ksusha");
        }
    }
}
