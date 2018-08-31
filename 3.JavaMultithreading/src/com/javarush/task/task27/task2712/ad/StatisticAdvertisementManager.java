package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public List<Advertisement> activeVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                result.add(advertisement);
            }
        }
        return result;
    }

    public List<Advertisement> archiveVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() == 0) {
                result.add(advertisement);
            }
        }
        return result;
    }

    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }
}
