package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cat catGrandFather = new Cat(reader.readLine());
        Cat catGrandMother = new Cat(reader.readLine());
        Cat catFather = new Cat(reader.readLine(), null, catGrandFather);
        Cat catMother = new Cat(reader.readLine(), catGrandMother, null);
        Cat catSon = new Cat(reader.readLine(), catMother, catFather);
        Cat catDaughter = new Cat(reader.readLine(), catMother, catFather);



        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Cat name is ").append(this.name);
            if (this.mother == null) {
                builder.append(", no mother");
            } else {
                builder.append(", mother is ").append(this.mother.name);
            }
            if (this.father == null) {
                builder.append(", no father");
            } else {
                builder.append(", father is ").append(this.father.name);
            }
            return builder.toString();
        }
    }

}
