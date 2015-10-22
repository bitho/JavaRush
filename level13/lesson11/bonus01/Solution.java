package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inStream = new FileInputStream(fileName);
        String s;
        List<Integer> list = new ArrayList<Integer>();
        InputStream input = new FileInputStream(fileName);
        Scanner sc = new Scanner(input);
        while (input.available()>0)
        {
            while(sc.hasNextInt())
            {
                int data = sc.nextInt();
                list.add(data);
            }
        }
        for (int i = 0; i < list.size()-1; i++)
        {
            for (int j = 0; j < list.size()-1; j++)
                if (list.get(i) > list.get(i+1))
                {
                    int tmp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i + 1, tmp);
                }
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i)%2 == 0) System.out.println(list.get(i));
        }

        reader.close();
        inStream.close(); //закрываем потоки
    }
}
