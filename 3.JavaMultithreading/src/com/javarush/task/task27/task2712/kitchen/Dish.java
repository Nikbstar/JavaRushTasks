package com.javarush.task.task27.task2712.kitchen;

public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    public static String allDishesToString() {
        StringBuilder builder = new StringBuilder();
        for (Dish dish : Dish.values()) {
            builder.append(dish).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

}
