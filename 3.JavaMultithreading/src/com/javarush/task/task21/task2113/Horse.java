package com.javarush.task.task21.task2113;

public class Horse {

    private String name;
    private double speed;
    private double distance;

    public void move() {
        this.setDistance(getDistance() + getSpeed() * Math.random());
    }

    public void print() {
        for (int i = 0; i < (int) this.distance; i++) {
            System.out.print('.');
        }
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return this.speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return this.distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance) {
        setName(name);
        setSpeed(speed);
        setDistance(distance);
    }
}
