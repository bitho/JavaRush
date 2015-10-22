package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileToWrite = br.readLine();

        PrintWriter writer = new PrintWriter(fileToWrite);

        List<String> strings = new LinkedList<String>();
        String line = "";

        while(true) {
            line = br.readLine();
            strings.add(line);
            if (line.equals("exit")) break;
        }
        for(String string: strings) {
            writer.println(string);
        }

        writer.close();
        br.close();
    }
}