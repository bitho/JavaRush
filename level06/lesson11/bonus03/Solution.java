package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int n1, n2, n3 , n4, n5;

            n1 = Integer.parseInt(reader.readLine());
            n2 = Integer.parseInt(reader.readLine());
            n3 = Integer.parseInt(reader.readLine());
            n4 = Integer.parseInt(reader.readLine());
            n5 = Integer.parseInt(reader.readLine());

        int[] arr = {n1, n2, n3, n4, n5};

        for (int j = 0; j < (arr.length - 1); j++)
        {
            for (int i = 0; i < (arr.length - 1); i++)
            {
                if (arr[i] > arr[i+1])
                {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }


        for (int i = 0; i < arr.length; i++)
        System.out.println(arr[i]);


    }
}
