package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(s);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();

            if (!map.containsKey(i)){
                map.put(i, 1);
            }
            else {
                map.put(i, map.get(i) + 1);
            }
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() > max){
                max = pair.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == max){
                System.out.print(pair.getKey() + " ");
            }
        }

        reader.close();
        fileInputStream.close();
    }
}