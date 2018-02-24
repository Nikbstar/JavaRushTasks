package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args[0].equals("-c")) {
            create(args[2], args[1], args[3]);
        } else if (args[0].equals("-u")) {
            update(Integer.parseInt(args[1]), args[3], args[2], args[4]);
        } else if (args[0].equals("-d")) {
            delete(Integer.parseInt(args[1]));
        } else if (args[0].equals("-i")) {
            print(Integer.parseInt(args[1]));
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
