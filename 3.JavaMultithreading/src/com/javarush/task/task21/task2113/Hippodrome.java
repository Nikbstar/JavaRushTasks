package com.javarush.task.task21.task2113;

import java.util.List;
import java.util.ArrayList;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public void run() {
        for (int i = 1; i <= 100; i++) {
            this.move();
            this.print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : this.horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : this.horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse result = getHorses().get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > result.getDistance()) {
                result = horse;
            }
        }
        return result;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!%s", getWinner().getName(), System.lineSeparator());
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Kolya", 3, 0));
        horses.add(new Horse("Katya", 3, 0));
        horses.add(new Horse("Ksusha", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

}
