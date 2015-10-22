package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException, DownloadException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();

        try
        {
            while (!inFile.equals(""))
            {
                FileInputStream in = new FileInputStream(inFile);
                if (in.available() < 1000)
                {
                    in.close();
                    throw new DownloadException();

                } else
                {
                    in.close();
                    inFile = reader.readLine();
                }
            }
        }
        catch (DownloadException e)
        {
            throw new DownloadException();
        }
        reader.close();

    }

    public static class DownloadException extends Exception
    {
    }
}