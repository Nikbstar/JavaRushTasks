package com.javarush.task.task23.task2312;

public class Room {

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    public Room(final int width, final int height, final Snake snake) {
        this.setWidth(width);
        this.setHeight(height);
        this.setSnake(snake);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void setSnake(final Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public void setMouse(final Mouse mouse) {
        this.mouse = mouse;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(200, 200);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(400, 400, snake);
    }

    public void run() {

    }

    public void print() {

    }

}
