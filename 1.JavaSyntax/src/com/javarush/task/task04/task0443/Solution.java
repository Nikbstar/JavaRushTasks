package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String y = reader.readLine();
        String m = reader.readLine();
        String d = reader.readLine();
        System.out.printf("Меня зовут %s.%s", name, System.lineSeparator());
        System.out.printf("Я родился %s.%s.%s", d, m, y);
    }
}
