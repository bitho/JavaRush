package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
public class Solution {
    static String substr = "world";
    static int counter = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready())
        {
            String[] s = fileReader.readLine().replaceAll("\\p{Punct}", " ").split(" ");
            for (String ss : s)
                if (ss.equals(substr)) counter++;
        }
        reader.close(); fileReader.close();
        String s = sb.toString().toLowerCase();
        for (int j = 0; j <= s.length()-substr.length(); j++)
        {
            if ( s.substring(j, j+substr.length()).equals(substr) ) counter++;
        }
        System.out.println(counter);
    }
}