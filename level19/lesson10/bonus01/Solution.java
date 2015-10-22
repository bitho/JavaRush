package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.*;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/



    public class Solution {
        public static List<LineItem> lines = new ArrayList<LineItem>();

        public static void main(String[] args) throws Exception{
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
            String fileName1 =reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();

            BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));

            while (reader1.ready())
            {
                list1.add(reader1.readLine());
            }
            reader1.close();
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

            while (reader2.ready())
            {
                list2.add(reader2.readLine());
            }
            reader2.close();

            int j = 0;
            int i = 0;
            while (true)
            {
                if (list1.get(i).equals(list2.get(j)))
                {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    j++;
                    i++;
                } else if (j < list2.size() - 1 && list1.get(i).equals(list2.get(j + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                } else if (i < list1.size() - 1 && list1.get(i + 1).equals(list2.get(j)))
                {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                }
                else

                    break;

                if (i== list1.size() && j < list2.size())
                {
                    for (;j< list2.size();j++)
                        lines.add(new LineItem(Type.ADDED, list2.get(j)));

                }

                if (j == list2.size() && i < list1.size())
                {
                    for (; i<list1.size(); i++)
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));

                }

                if (i == list1.size() && j == list2.size())
                    break;

            }


            for (LineItem x : lines)
                System.out.println(x.type+" "+ x.line);

        }


        public static enum Type {
            ADDED,        //добавлена новая строка
            REMOVED,      //удалена строка
            SAME          //без изменений
        }

        static class LineItem {
            public Type type;
            public String line;

            public LineItem(Type type, String line) {
                this.type = type;
                this.line = line;
            }
        }
    }