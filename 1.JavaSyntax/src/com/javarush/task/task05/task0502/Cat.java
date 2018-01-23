package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int thisScore = 0;
        int anotherScore = 0;
        if (this.age > anotherCat.age) {
            thisScore++;
        } else if (this.age < anotherCat.age) {
            anotherScore++;
        }
        if (this.weight > anotherCat.weight) {
            thisScore++;
        } else if (this.weight < anotherCat.weight) {
            anotherScore++;
        }
        if (this.strength > anotherCat.strength) {
            thisScore++;
        } else if (this.strength < anotherCat.strength) {
            anotherScore++;
        }
        return thisScore > anotherScore;
    }

    public static void main(String[] args) {

    }
}
