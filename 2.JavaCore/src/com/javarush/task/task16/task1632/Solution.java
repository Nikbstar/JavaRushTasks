package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) {
    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        while (true) {}
    }
}
class ThreadTwo extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException");
        }
    }
}

class ThreadThree extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadFour extends Thread implements Message {
    @Override
    public void showWarning() {
        this.interrupt();
    }
    @Override
    public void run() {
        while(!this.isInterrupted()) {
        }
    }
}

class ThreadFive extends Thread {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data;
        int result = 0;
        try {
            while (true) {
                data = reader.readLine();
                if (data.equals("N")) {
                    break;
                }
                result += Integer.parseInt(data);
            }
            System.out.println(result);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}