package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length==4) {
            if (args[0].equals("-c")) {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader1.readLine();
            reader1.close();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Integer> listID = new LinkedList<Integer>();
            String getID = "";
            while ((getID = reader.readLine()) != null)
            {
                getID = getID.substring(0, 8).trim();
                int id = Integer.parseInt(getID);
                listID.add(id);
            }
            Collections.sort(listID);
            int nextID = listID.get(listID.size()-1) + 1;
            reader.close();

            String productName = "";
            String price = "";
            String quantity = "";
            String product = "";

            productName = args[args.length - 3];
            price = args[args.length - 2];
            quantity = args[args.length - 1];

            product = String.format("%-8d%-30.30s%-8.8s%-4.4s", nextID, productName, price, quantity);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(product);

            writer.close();
        }}

    }
}
