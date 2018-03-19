package com.javarush.task.task20.task2027;

import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        for (String word : words) {
            int startX;
            int endX;
            int startY;
            int endY;
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == word.charAt(0)) {
                        startX = i;
                        startY = j;
                        int[] dir = checkDirection(crossword, word.charAt(1), startX, startY);
                    } else if (crossword[i][j] == word.charAt(word.length() - 1)) {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }
        return null;
    }
    private static int[] checkDirection(int[][] crossword, char nextChar, int i, int j) {
        if (i + 1 < crossword.length) {

        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
