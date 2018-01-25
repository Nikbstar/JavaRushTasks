package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> modThree = new ArrayList<>();
        ArrayList<Integer> modTwo = new ArrayList<>();
        ArrayList<Integer> allOther = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
            if (integers.get(i) % 3 == 0) {
                modThree.add(integers.get(i));
            }
            if (integers.get(i) % 2 == 0) {

                modTwo.add(integers.get(i));
            }
            if (integers.get(i) % 3 != 0 && integers.get(i) % 2 != 0) {
                allOther.add(integers.get(i));
            }
        }
        Solution.printList(modThree);
        Solution.printList(modTwo);
        Solution.printList(allOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
