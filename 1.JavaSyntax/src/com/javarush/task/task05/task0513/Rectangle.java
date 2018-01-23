package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;

    public void initialize(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int left) {
        this.initialize(top, left, 0, 0);
    }

    public void initialize(int top, int left, int height) {
        this.initialize(top, left, height, height);
    }

    public void initialize(Rectangle rectangle) {
        this.initialize(rectangle.getTop(), rectangle.getLeft(), rectangle.getWidth(), rectangle.getHeight());
    }

    public static void main(String[] args) {

    }
}
