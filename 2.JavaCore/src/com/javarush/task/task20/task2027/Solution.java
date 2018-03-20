package com.javarush.task.task20.task2027;

import java.util.ArrayList;
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
        for (Word word : detectAllWords(crossword, "u", "home", "same")) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsResult = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (word.length() == 1 && crossword[i][j] == word.charAt(0)) {
                        Word tmp = new Word(word);
                        tmp.setStartPoint(j, i);
                        tmp.setEndPoint(j, i);
                        wordsResult.add(tmp);
                    } else {
                        if (crossword[i][j] == word.charAt(0)) {
                            int[] endPoint = checkWord(crossword, word, i, j);
                            if (endPoint[0] != 0 || endPoint[1] != 0) {
                                Word tmp = new Word(word);
                                tmp.setStartPoint(j, i);
                                tmp.setEndPoint(endPoint[1], endPoint[0]);
                                wordsResult.add(tmp);
                            }
                        }
                        if (crossword[i][j] == word.charAt(word.length() - 1)) {
                            int[] startPoint = checkWord(crossword, reverse(word), i, j);
                            if (startPoint[0] != 0 || startPoint[1] != 0) {
                                Word tmp = new Word(word);
                                tmp.setStartPoint(startPoint[1], startPoint[0]);
                                tmp.setEndPoint(j, i);
                                wordsResult.add(tmp);
                            }
                        }
                    }
                }
            }
        }
        return wordsResult;
    }
    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
    private static int[] checkWord(int[][] crossword, String word, int startI, int startJ) {
        int[] dir = new int[2];
        int[] result = {0, 0};
        char nextChar = word.charAt(1);
        if (startI + word.length() <= crossword.length && (char) crossword[startI + 1][startJ] == nextChar) {
            dir[0] = 1;
            dir[1] = 0;
        } else if (startJ + word.length() <= crossword[startI].length && (char) crossword[startI][startJ + 1] == nextChar) {
            dir[0] = 0;
            dir[1] = 1;
        } else if (startI + word.length() <= crossword.length && startJ + word.length() <= crossword[startI].length && (char) crossword[startI + 1][startJ + 1] == nextChar) {
            dir[0] = 1;
            dir[1] = 1;
        } else {
            dir[0] = -1;
        }
        if (dir[0] != -1) {
            boolean checkWord = true;
            int endI = startI;
            int endJ = startJ;
            for (int i = 1; i < word.length(); i++) {
                endI += dir[0];
                endJ += dir[1];
                if (word.charAt(i) != crossword[endI][endJ]) {
                    checkWord = false;
                    break;
                }
            }
            if (checkWord) {
                result[0] = endI;
                result[1] = endJ;
            }
        }
        return result;
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
