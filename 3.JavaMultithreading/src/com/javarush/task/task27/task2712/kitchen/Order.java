package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    public Order(Tablet tablet) throws IOException { this.tablet = tablet; }

    protected List<Dish> dishes = ConsoleHelper.getAllDishesForOrder();

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish : dishes) {
            result += dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty() {
        return dishes.size() == 0;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public String getTabletName() {
        return this.tablet.toString();
    }

    @Override
    public String toString() {
        return (dishes.size() > 0) ? String.format("Your order: %s of %s", dishes, tablet.toString()) : "";
    }
}
