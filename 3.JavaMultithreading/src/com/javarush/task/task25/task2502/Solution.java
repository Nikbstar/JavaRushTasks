package com.javarush.task.task25.task2502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            Set<Wheel> result = new HashSet<>();
            for (String s : this.loadWheelNamesFromDB()) {
                Wheel wheel = Wheel.valueOf(s);
                if (result.contains(wheel)) {
                    throw new RuntimeException();
                }
                result.add(wheel);
            }
            if (result.size() != 4) {
                throw new RuntimeException();
            }
            this.wheels = new LinkedList<>(result);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}
