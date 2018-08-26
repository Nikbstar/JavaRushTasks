package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private List<Advertisement> advertisementsListToShow = null;

    private int timeSeconds;

    public void processVideos() {
        if (storage.list().size() == 0) {
            throw new NoVideoAvailableException();
        } else {
            makeAllSets(storage.list());
            for (Advertisement advertisement : advertisementsListToShow) {
                System.out.println(String.format("%s is displaying... %d %d",
                        advertisement.getName(),
                        advertisement.getAmountPerOneDisplaying(),
                        1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
            }
        }
    }

    private void makeAllSets(List<Advertisement> list) {
        if (list.size() > 0) {
            if (this.advertisementsListToShow == null) {
                if (this.calcSeconds(list) <= this.timeSeconds) {
                    this.advertisementsListToShow = list;
                }
            } else {
                if (this.calcSeconds(list) <= this.timeSeconds && this.calcPrice(list) > this.calcPrice(this.advertisementsListToShow)) {
                    this.advertisementsListToShow = list;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            List<Advertisement> newSet = new ArrayList<>(list);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    private int calcSeconds(List<Advertisement> list) {
        int result = 0;
        for (Advertisement advertisement : list) {
            result += advertisement.getDuration();
        }
        return result;
    }

    private long calcPrice(List<Advertisement> list) {
        long result = 0;
        for (Advertisement advertisement : list) {
            result = advertisement.getAmountPerOneDisplaying();
        }
        return result;
    }

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

}
