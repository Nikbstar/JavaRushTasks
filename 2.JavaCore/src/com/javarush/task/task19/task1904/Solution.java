package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ");
            for (String datum : data) {
                System.out.println(datum);
            }
            return new Person(data[1], data[2], data[0], new Date(Integer.parseInt(data[5]) - 1900, Integer.parseInt(data[4]) - 1, Integer.parseInt(data[3])));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
