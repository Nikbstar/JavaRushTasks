package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Список блюд: ");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите список блюд (exit - чтобы закончить): ");
        String dish = readString();
        while(!dish.equals("exit")) {
            try {
                dishes.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException iae) {
                writeMessage("Такого блюда нет в списке!");
            }
            dish = readString();
        }
        return dishes;
    }

}
