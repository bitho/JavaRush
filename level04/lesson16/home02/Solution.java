package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n1 = br.readLine();
        int num1 = Integer.parseInt(n1);
        String n2 = br.readLine();
        int num2 = Integer.parseInt(n2);
        String n3 = br.readLine();
        int num3 = Integer.parseInt(n3);

        if (((num1 < num2) && (num1 > num3)) || ((num1 < num3) && (num1 > num2)))
        {
            System.out.print(num1);
        } else if (((num2 < num1) && (num2 > num3)) || ((num2 < num3) && (num2 > num1)))
        {
            System.out.print(num2);
        }
        else if (((num3 < num1) && (num3 > num2)) || ((num3 < num2) && (num3 > num1)))
        {
            System.out.print(num3);
        }
    }
}
