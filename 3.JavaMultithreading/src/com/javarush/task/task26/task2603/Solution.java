package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = this.comparators[0].compare(o1, o2);
            int i = 1;
            while (result == 0 && i < this.comparators.length) {
                result = this.comparators[i++].compare(o1, o2);
            }
            return result;
        }
    }

}
