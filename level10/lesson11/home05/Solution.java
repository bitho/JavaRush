package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }
        //alphabet.add(6,'ё');
        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            s.toLowerCase();

            list.add(s.toLowerCase());
        }
        String s = "";
        for (int i = 0; i < list.size(); i++)
        {
            s += list.get(i);
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

           for (int j = 0; j < alphabet.size(); j++)
            {
                int count = 0;
                for (int i = 0; i < chars.length; i++)
                {
                    if (alphabet.get(j).equals(chars[i])) count++;
                }
                //if (count == 0) continue;
                //map.put(alphabet.get(j), count);
                System.out.println(alphabet.get(j) + " " + count);
            }
        /*Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Character, Integer> pair = iterator.next();
            Character key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " " + value);
        }*/
    }

}
