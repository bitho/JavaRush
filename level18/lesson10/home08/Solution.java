package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/
public class Solution
{
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("exit"))
        {
            new ReadThread(line).start();
        }
        reader.close();
    }
    public static class ReadThread extends Thread
    {
        Map<Integer, Integer> byteMap = new HashMap<Integer, Integer>();
        String fileName;
        public ReadThread(String fileName) throws FileNotFoundException
        {
            this.fileName = fileName;
        }
        @Override
        public void run()
        {
            try
            {
                FileInputStream fos = new FileInputStream(fileName);
                int buf;
                while (fos.available() > 0)
                {
                    buf = fos.read();
                    if (!byteMap.containsKey(buf))
                        byteMap.put(buf, 1);
                    else
                        byteMap.put(buf, byteMap.get(buf) + 1);
                }
                fos.close();
                int maxValue = -1; int maxKey = -1;
                for (Map.Entry<Integer, Integer> entry:  byteMap.entrySet())
                {
                    if (entry.getValue() > maxValue)
                    {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                resultMap.put(fileName, maxKey);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}