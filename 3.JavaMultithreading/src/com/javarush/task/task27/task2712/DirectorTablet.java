package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<Integer, Long> sorted = new TreeMap<>(Collections.reverseOrder());
        sorted.putAll(StatisticManager.getInstance().advertisementProfit());
        for (Integer integer : sorted.keySet()) {
            if (integer != -1) {
                float resultSum = sorted.get(integer) / 100f;
                Date resultDate = new Date();
                resultDate.setDate(integer);
                String dateFormat = new SimpleDateFormat("dd-MMM-yyyy").format(resultDate);
                ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat, resultSum));
            }
        }
        float totalSum = sorted.get(-1) / 100f;
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalSum));
    }

    public void printCookWorkloading() {
        Map<Integer, Map<String, Integer>> sorted = new TreeMap<>(Collections.reverseOrder());
        sorted.putAll(StatisticManager.getInstance().cookWorkloading());
        for (Integer integer : sorted.keySet()) {
            Date resultDate = new Date();
            resultDate.setDate(integer);
            String dateFormat = new SimpleDateFormat("dd-MMM-yyyy").format(resultDate);
            ConsoleHelper.writeMessage(dateFormat);
            for (Map.Entry<String, Integer> entry : sorted.get(integer).entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", entry.getKey(), entry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {}

    public void printArchivedVideoSet(){}

}
