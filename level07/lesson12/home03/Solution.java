package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = 0;
        int minimum = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        list.add(Integer.parseInt(reader.readLine()));

        for (int j = 0; j < 19; j++)
        {
            for (int i = 0; i < (list.size() - 1); i++)
            {
                if (i < (list.size() - 2))
                {
                if (list.get(i) > list.get(i + 1))
                {
                    list.add(i + 2, list.get(i));
                    list.remove(i);
                }
                }
                if (i >= (list.size() - 2)){
                    if (list.get(i) > list.get(i + 1)){
                        list.add(list.get(i));
                        list.remove(i);}
                }

            }
        }

        maximum = list.get(19);
        //for (int i = 0; i < list.size(); i++)
        //    System.out.println(list.get(i));
        for (int j = 0; j < 19; j++)
        {
            for (int i = 0; i < (list.size() - 1); i++)
            {
                if (i < (list.size() - 2)){
                if (list.get(i) < list.get(i + 1)){
                    list.add(i + 2, list.get(i));
                    list.remove(i);}
                }
                if (i >= (list.size() - 2))
                {
                    if (list.get(i) < list.get(i + 1))
                    {
                        list.add(list.get(i));
                        list.remove(i);
                    }
            }   }
        }
        minimum = list.get(19);
        //for (int i = 0; i < list.size(); i++)
        //System.out.println(list.get(i));
        System.out.println(maximum + " " + minimum);

    }
}
