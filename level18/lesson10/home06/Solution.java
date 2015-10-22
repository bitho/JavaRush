package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        if (args.length > 0) {
            FileReader in = new FileReader(args[0]);
            while (in.ready()) {
                int SymbolIn = in.read();
                int count = 1;
                for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()) {
                    if (SymbolIn == pair.getKey()) {
                        count = count + pair.getValue();
                    }
                }
                treeMap.put(SymbolIn, count);
            }
            in.close();
            for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()) {
                int key = pair.getKey();
                int value = pair.getValue();
                System.out.println((char)key + " " + value);
            }
        }
    }
}