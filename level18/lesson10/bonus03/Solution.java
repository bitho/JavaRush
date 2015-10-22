package com.javarush.test.level18.lesson10.bonus03;

    /* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
        import java.io.*;
        import java.util.*;
        import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        if ((args.length == 5 && args[0].equals("-u"))
                || (args.length == 2 && args[0].equals("-d")))
        {
            try
            {
                Integer.parseInt(args[1]);

            } catch (NumberFormatException e) {return;}
            if (args[1].length() > 8) return;

            String id = args[1];
            id = String.format("%-8s", id);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fileName));

            List<String> listGoods = new ArrayList<String>();
            String getGoods = "";
            if (args[0].equals("-u") && args.length == 5)
            {
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];
                String product = String.format("%-8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);

                while ((getGoods = reader.readLine()) != null)
                {
                    if (getGoods.substring(0,8).equals(id)) {getGoods = product;}
                    listGoods.add(getGoods);
                }
            }
            else if (args[0].equals("-d") && args.length == 2)
            {
                while ((getGoods = reader.readLine()) != null)
            {
                if (!getGoods.substring(0,8).equals(id))
                {listGoods.add(getGoods);}
                else {continue;}
            }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0; i < listGoods.size(); i++){
                if (i == listGoods.size()-1)writer.write(listGoods.get(i));
                else{writer.write(listGoods.get(i));
                writer.newLine();}
            }
            writer.close();
        }
        else return;
    }
}
