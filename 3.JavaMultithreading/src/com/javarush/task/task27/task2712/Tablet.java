package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {

    final int number;
    public Tablet(int number) { this.number = number; }

    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                try {
                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                } catch (NoVideoAvailableException nvae) {
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
                setChanged();
                notifyObservers(order);
            }
        } catch (IOException e) {
            logger.severe("Console is unavailable.");
        }
        return order;
    }

    public void createTestOrder() {
        Order order;
        try {
            order = new Order(this);
            int randomOrdersCount = (int)((Math.random() * 9) + 1);
            for (int i = 0; i < randomOrdersCount; i++) {
                Dish[] dishes = Dish.values();
                int randomDish = (int) (Math.random() * (dishes.length - 1));
                order.getDishes().add(dishes[randomDish]);
            }
        } catch (IOException e) {
        }
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
