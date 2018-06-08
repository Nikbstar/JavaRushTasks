package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final List<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return this.sections;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public SnakeDirection getDirection() {
        return this.direction;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
}
