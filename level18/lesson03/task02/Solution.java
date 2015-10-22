package com.javarush.test.level18.lesson03.task02;

import java.io.*;
import java.util.ArrayList;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
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
        int min = list.get(0);
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) < min) min = list.get(i);
        }

        System.out.println(min);
        input.close();
        r.close();
    }
}