package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        List<Word> list;
        String s = "";
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'g', 'a', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        list = detectAllWords(crossword, /*"orgn", "same",*/"homes", "glp",  "pgae", "pgah", "kerpo", "ggj", "emoh", "plgm", "unpe", "same");
        for (Word w : list)
            System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        Word tempWord;
        int wordLength, x = crossword[0].length, y = crossword.length, endPointX = 0, endPointY = 0;
        String checkWord = "";
        for (String w : words) {
            wordLength = w.length();
            for (int i = 0; i < y; i++)
                for (int j = 0; j < x; j++) {
                    if (w.toCharArray()[0] == crossword[i][j]) {
                        if (j >= wordLength - 1) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = j; k > j - wordLength; k--) {
                                checkWord += (char) crossword[i][k];
                                endPointX = k;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, i);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                        if (x - j >= wordLength) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = j; k < j + wordLength; k++) {
                                checkWord += (char) crossword[i][k];
                                endPointX = k;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, i);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }

                        if (i >= wordLength - 1) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i; k > i - wordLength; k--) {
                                checkWord += (char) crossword[k][j];

                                endPointY = k;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(j, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                        if (y - i >= wordLength) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i; k < i + wordLength; k++) {
                                checkWord += (char) crossword[k][j];
                                endPointY = k;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(j, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }

                        if (i >= wordLength - 1 && j >= wordLength - 1) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i, l = j; k > i - wordLength; k--, l--) {
                                checkWord += (char) crossword[k][l];
                                endPointY = k;
                                endPointX = l;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                        if (y - i >= wordLength && j >= wordLength - 1) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i, l = j; k < i + wordLength; k++, l--) {
                                checkWord += (char) crossword[k][l];
                                endPointY = k;
                                endPointX = l;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                        if (i >= wordLength - 1 && x - j >= wordLength) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i, l = j; k > i - wordLength; k--, l++) {
                                checkWord += (char) crossword[k][l];
                                endPointY = k;
                                endPointX = l;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                        if (y - i >= wordLength && x - j >= wordLength) {
                            tempWord = new Word(w);
                            tempWord.setStartPoint(j, i);
                            for (int k = i, l = j; k < i + wordLength; k++, l++) {
                                checkWord += (char) crossword[k][l];
                                endPointY = k;
                                endPointX = l;
                            }
                            if (w.equals(checkWord)) {
                                tempWord.setEndPoint(endPointX, endPointY);
                                list.add(tempWord);
                            }
                            checkWord = "";
                        }
                    }
                }

        }
        //System.out.println(x + " " + y);
        return list;
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