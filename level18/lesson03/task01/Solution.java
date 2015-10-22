package com.javarush.test.level18.lesson03.task01;

import java.io.*;
import java.util.ArrayList;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(r.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (input.available() > 0)
        {
            list.add(input.read());
        }
        int max = list.get(0);
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) > max) max = list.get(i);
        }

        System.out.println(max);
        input.close();
        r.close();
    }
}