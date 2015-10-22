package com.javarush.test.level18.lesson03.task04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = new FileInputStream(reader.readLine());
        reader.close();
        while(in.available() > 0) {
            int tmp = in.read();
            if(map.containsKey(tmp))
                map.put(tmp, map.get(tmp) +1);
            else
                map.put(tmp, 1);
        }
        in.close();
        int count = Integer.MAX_VALUE;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if(count > mapEntry.getValue()) {
                count = mapEntry.getValue();
            }
        }

        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if(mapEntry.getValue() == count)
                list.add(mapEntry.getKey());
        }

        System.out.println(map);
        System.out.print(list);
    }
}