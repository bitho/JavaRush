package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName = br.readLine();
            br = new BufferedReader(new FileReader(fileName));
            String str;
            String tempString = "";
            while ((str = br.readLine()) != null)
            {
                tempString += str;
            }
            StringBuilder result = getLine(tempString.split(" "));
            System.out.println(result.toString());
            br.close();
        }
        catch (Exception e)
        {
            return;
        }

    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder();

        if (words.length==1) {
            sb.append(words[0].trim());
            return sb;
        }


        List<String> list = Arrays.asList(words);
        while (true)
        {
            Collections.shuffle(list);
            int count = 0;
            for (int i = 0; i < list.size() - 1; i++)
            {

                if (words[i].toLowerCase().charAt(list.get(i).length() - 1)
                        == list.get(i+1).toLowerCase().charAt(0))
                {
                    count++;
                }
            }
            if (count==words.length-1) break;
        }
        for (int k = 0; k < list.size(); k++)
            sb.append(list.get(k) + " ");



        sb.deleteCharAt(sb.toString().length()-1);

          return sb;
    }
}
