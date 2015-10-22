package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args)  {
        String filename = args[0];
        Map<String, Double> map = new HashMap<String, Double>();
        ArrayList<String> sortedlist = new ArrayList<String>();

        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) { /* NNN */ }


        while (sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            if (map.containsKey(temp[0])){
                double val = map.get(temp[0]) + Double.parseDouble(temp[1]);
                map.put(temp[0], val);
            }
            else map.put(temp[0], Double.parseDouble(temp[1]));
        }

        for(Map.Entry<String, Double> entry : map.entrySet()){
            sortedlist.add(entry.getKey());
        }

        Collections.sort(sortedlist);

        for (String val : sortedlist){
            for(Map.Entry<String, Double> entry : map.entrySet()){
                if (val.equals(entry.getKey())){
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        }
        sc.close();
    }
}