package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] chars = s.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 0; i < chars.length - 1; i++) {
            String a = Character.toString(chars[i]);
            if (a.equals(" "))
                chars[i + 1] = Character.toUpperCase(chars[i + 1]);
        }
        s = "";
        for (int i = 0; i < chars.length; i++)
        {
            s = s + chars[i];
        }
        System.out.print(s);

/*
        String[] words = s.split(" ");
        System.out.println(words.length);
        String output = "";
        /*char[] arr = words[0].toCharArray();
        for (int i = 0; i < arr.length; i++)
        if (Character.)*/
        /*for (String word : words)
        {
            String first = word.substring(0,1).toUpperCase();
            String all = word.substring(1);
            output += first + all + " ";
        }
        s = output;
        words = s.split(" ");
        System.out.println(words.length);
        s = words[0];
        for (int i = 1; i < words.length; i++)
        {
            s += " " + words[i];
        }

        System.out.print(s);*/
    }


}
