package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    private final String name;

    @Override
    public void update(Observable o, Object arg) {
        // Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", arg.toString(), ((Order) arg).getTotalCookingTime()));
        setChanged();
        notifyObservers(arg);
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
