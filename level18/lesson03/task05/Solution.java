package com.javarush.test.level18.lesson03.task05;

import java.io.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> resultArray;

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bfReader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName);

        while (fileReader.available() > 0){
            array.add(fileReader.read());
        }

        resultArray = new ArrayList<Integer>(new HashSet<Integer>(array));
        Collections.sort(resultArray);



        for (Integer one : resultArray)
            System.out.print(one + " ");

        bfReader.close();
        fileReader.close();



    }
}
