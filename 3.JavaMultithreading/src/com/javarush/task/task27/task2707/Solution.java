package com.javarush.task.task27.task2707;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        final boolean[] result = {false};
        synchronized (o1) {
            Thread t1 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));
            t1.setDaemon(true);
            t1.start();
            while (true) {
                if (t1.getState() == Thread.State.BLOCKED) {
                    break;
                }
            }
            Thread t2 = new Thread(() -> {
                synchronized (o2) {
                    result[0] = true;
                }
            });
            t2.setDaemon(true);
            t2.start();
            while (true) {
                if (t2.getState() == Thread.State.BLOCKED  || result[0] == true) {
                    break;
                }
            }
        }
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
