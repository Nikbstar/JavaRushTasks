package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> sets = new HashSet<>();
        Collections.addAll(sets, "арбуз", "банан", "вишня", "груша", "дыня", "ежевика", "жень-шень",
                "земляника", "ирис", "картофель");

        Iterator<String> iterator = sets.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
