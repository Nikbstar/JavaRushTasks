package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    private static StatisticManager instance = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();

    Set<Cook> cooks = new HashSet<>();

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Integer, Long> advertisementProfit() {
        List<EventDataRow> eventDataRows = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        Map<Integer, Long> dateSum = new HashMap<>();
        long totalSum = 0;
        for (EventDataRow dataRow : eventDataRows) {
            int date = dataRow.getDate().getDate();
            long sum = ((VideoSelectedEventDataRow)dataRow).getAmount();
            if (dateSum.containsKey(date)) {
                dateSum.put(date, dateSum.get(date) + sum);
            } else {
                dateSum.put(date, sum);
            }
            totalSum += sum;
        }
        dateSum.put(-1, totalSum);
        return dateSum;
    }

    private StatisticManager() {}

    public static StatisticManager getInstance() {
        return instance;
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage;

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<>());
            }
        }

        private Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

}
