package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private final Thread thread;

    public LoggingStateThread(final Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State newState = this.thread.getState();
        Thread.State oldState = null;
        while (!this.isInterrupted()) {
            if (oldState != newState) {
                oldState = newState;
                System.out.println(oldState);
                if (oldState == State.TERMINATED) {
                    this.interrupt();
                }
            }
            newState = this.thread.getState();
        }
    }

}
