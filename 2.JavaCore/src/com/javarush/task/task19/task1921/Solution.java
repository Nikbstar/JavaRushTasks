package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        String data;
        while (fr.ready()) {
            data = fr.readLine();
            String name = data.replaceAll("\\d", "").trim();
            String date = data.substring(name.length() + 1);
            int year = Integer.parseInt(date.split(" ")[2]);
            int month = Integer.parseInt(date.split(" ")[1]);
            int day = Integer.parseInt(date.split(" ")[0]);
            PEOPLE.add(new Person(name, new Date(year - 1900, month - 1, day)));
        }
        fr.close();
    }
}
