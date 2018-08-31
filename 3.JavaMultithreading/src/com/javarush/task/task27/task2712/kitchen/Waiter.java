package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(String.format("%s was cooked by %s", arg.toString(), o.toString()));
        Order order = (Order) arg;
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        order.getTabletName(),
                        o.toString(),
                        order.getTotalCookingTime(),
                        order.getDishes()));
    }

}