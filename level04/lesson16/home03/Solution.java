package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{

    public static void main(String[] args)   throws Exception
    {
        int s = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            String n = br.readLine();
            int n1 = Integer.parseInt(n);


        if ((n1 == -1))
        {
            s += n1;
            System.out.println((s));
            break;
        }
            else s += n1;
        }
    }
}


