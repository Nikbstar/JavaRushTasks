package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Tablet tablet = new Tablet(3);
        DirectorTablet directorTablet = new DirectorTablet();
        Cook cook = new Cook("Amigo");
        cook.addObserver(new Waiter());
        tablet.addObserver(cook);
        tablet.createOrder();
        System.out.println("============================");
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }

}

class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;

    public RandomOrderGeneratorTask(List<Tablet> tablets) {
        this.tablets = tablets;
    }

    @Override
    public void run() {
        Tablet tablet = tablets.get((int) (Math.random() * (tablets.size() - 1)));
    }

}