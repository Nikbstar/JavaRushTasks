package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;

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

    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;

        this.width = width;
        this.height = height;
    }

    public Rectangle(int left, int top) {
        this(left, top, 0, 0);
    }

    public Rectangle(int left, int top, int width) {
        this(left, top, width, width);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getLeft(), rectangle.getTop(), rectangle.getWidth(), rectangle.getHeight());
    }

    public static void main(String[] args) {

    }
}
