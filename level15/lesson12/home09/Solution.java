package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = br.readLine();
        br.close();

        String[] urlArray = url.split("\\?");

        String dataUrl = "";
        for (int i = 1; i < urlArray.length; i++) {

            if (!urlArray[i].equals(" "))dataUrl += urlArray[i];

        }




        String[] data = dataUrl.split("&");

        double value = 0.0;
        String value1 = null;


        List<String> list = new LinkedList<String>();
         for (int i = 0; i < data.length; i++)
            {

                if (!data[i].equals(""))
                {

                    String[] obj = data[i].split("=");
                    list.add(obj[0]);
                          if (obj[0].equals("obj"))
                             {
                                 if(!data[1].equals(""))


                                 {try
                                  {
                                     value = Double.parseDouble(obj[1]);
                                  }
                                     catch (NumberFormatException e)
                                   {
                                      value1 = obj[1];
                                    }}

                }
                }
            }



        String str = "";
        for (int i = 0; i < list.size(); i++)
        {
            str = str + " " + list.get(i);
        }
        str = str.trim();
        System.out.println(str);


        if (value != 0) alert(value);
        if (value1 != null) alert(value1);
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
