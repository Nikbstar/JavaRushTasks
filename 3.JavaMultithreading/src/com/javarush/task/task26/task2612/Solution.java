package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        if (this.lock.tryLock()) {
            try {
                this.ifLockIsFree();
            } finally {
                this.lock.unlock();
            }
        } else {
            this.ifLockIsBusy();
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
