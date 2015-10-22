package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int min = 0;
        int max = 0;
        int nod = 0;
        if (a < b)
        {min = a; max = b;}
        else {min = b; max = a;}
        for (int i=1; i<min+1; i++)
        {
            if ((max%i == 0) &&(min%i == 0))
            {
                nod = i;
            }
        }
        System.out.print(nod);

    }
}
