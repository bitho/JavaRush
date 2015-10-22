package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*    int N = Integer.parseInt(reader.readLine());

        int maximum = 0;
        for (int i = 0; i < N; i++)
        {
            int m = Integer.parseInt(reader.readLine());
            if (maximum < m) maximum = m;
        }

        System.out.println(maximum);
    }
}*/
        int n = 0;
        while (true)
        {
            n = Integer.parseInt(reader.readLine());
            if (n > 0) break;
            else continue;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        int max = 0;
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
        max = arr[(arr.length-1)];
        System.out.println(max);

    }
}