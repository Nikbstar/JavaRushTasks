package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        create(args[i + 1], args[i], args[i + 2]);
                    }
                    break;
                }
            case "-u" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(Integer.parseInt(args[i]), args[i + 2], args[i + 1], args[i + 3]);
                    }
                    break;
                }
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(Integer.parseInt(args[i]));
                    }
                    break;
                }
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        print(Integer.parseInt(args[i]));
                    }
                    break;
                }
        }
    }

    private static void create(String sex, String name, String date) {
        Person person = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (sex.equals("м")) {
                person = Person.createMale(name, sdf.parse(date));
            } else if (sex.equals("ж")) {
                person = Person.createFemale(name, sdf.parse(date));
            }
            allPeople.add(person);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(allPeople.indexOf(person));
    }

    private static void update(int id, String sex, String name, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (sex.equals("м")) {
                allPeople.set(id, Person.createMale(name, sdf.parse(date)));
            } else if (sex.equals("ж")) {
                allPeople.set(id, Person.createFemale(name, sdf.parse(date)));
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    private static void delete(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    private static void print(int id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.printf("%s %s %s%s",
                allPeople.get(id).getName(),
                allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж",
                sdf.format(allPeople.get(id).getBirthDay()),
                System.lineSeparator());
    }
}
