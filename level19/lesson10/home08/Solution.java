package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String file = reader1.readLine();

        BufferedReader reader2 = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = reader2.readLine()) != null){
            String out = "";
            for (int i = line.length() -1; i >= 0 ; i--)
            {
                out += line.substring(i,i+1);
            }
            System.out.println(out);
        }
        reader1.close();
        reader2.close();
    }
}