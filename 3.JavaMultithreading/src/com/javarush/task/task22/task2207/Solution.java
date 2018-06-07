package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fis = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while(fis.ready()) {
            sb.append(fis.readLine().trim());
            sb.append(" ");
        }
        fis.close();
        String[] split = sb.toString().split(" ");
        for (int i = 0; i < split.length; i++) {
            String rev = new StringBuilder(split[i]).reverse().toString();
            for (int j = 0; j < split.length; j++) {
                if (i != j && rev.equals(split[j])) {
                    Pair pair1 = new Pair(split[i], split[j]);
                    Pair pair2 = new Pair(split[j], split[i]);
                    if (!result.contains(pair1) && !result.contains(pair2)) {
                        result.add(pair1);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
