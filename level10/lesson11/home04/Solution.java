package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        char[] arr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < arr.length; i++)
        {
            list.add(arr[i]);
        }
        System.out.println(s);
        for (int i = 0; i < 39; i++)
        {

            list.remove(0);
            for (int j = 0; j < list.size(); j++)
                System.out.print(list.get(j));

            System.out.println("");


        }
    }

}
