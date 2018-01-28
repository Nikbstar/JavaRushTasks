package com.javarush.task.task08.task0824;

import java.util.ArrayList;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human childOne = new Human("ChildOne", true, 3, new ArrayList<>());
        Human childTwo = new Human("ChildTwo", false, 6, new ArrayList<>());
        Human childThree = new Human("ChildThree", true, 10, new ArrayList<>());
        ArrayList<Human> children = new ArrayList<>();
        children.add(childOne);
        children.add(childTwo);
        children.add(childThree);
        Human mother = new Human("Mother", false, 30, children);
        Human father = new Human("Father", true, 33, children);
        ArrayList<Human> motherList = new ArrayList<>();
        motherList.add(mother);
        Human grandMotherM = new Human("GrandMotherM", false, 50, motherList);
        Human grandFatherM = new Human("GrandFatherM", true, 53, motherList);
        ArrayList<Human> fatherList = new ArrayList<>();
        fatherList.add(father);
        Human grandMotherF = new Human("GrandMotherF", false, 55, fatherList);
        Human grandFatherF = new Human("GrandFatherF", true, 58, fatherList);

        System.out.println(grandFatherF);
        System.out.println(grandFatherM);
        System.out.println(grandMotherF);
        System.out.println(grandMotherM);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(childOne);
        System.out.println(childTwo);
        System.out.println(childThree);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
