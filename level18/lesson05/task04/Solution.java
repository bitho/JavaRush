package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream input = new FileInputStream(reader1.readLine());
        FileOutputStream output2 = new FileOutputStream(reader1.readLine());

        byte[] b = new byte[input.available()];
        input.read(b);
        byte[] a = new byte[b.length];
        int s = b.length-1;

        for (int i = 0; i < b.length; i++)
        {
            a[i] = b[s--];
        }
        output2.write(a);
        reader1.close();

        input.close();
        output2.close();

    }
}