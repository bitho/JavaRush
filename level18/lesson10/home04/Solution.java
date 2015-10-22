package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File cleanFile;

        FileInputStream fis = new FileInputStream(file1);
        byte[] file1Content = new byte[fis.available()];
        fis.read(file1Content);
        file1.delete();

        cleanFile = new File(fileName1);
        cleanFile.createNewFile();

        fis = new FileInputStream(file2);
        byte[] file2Content = new byte[fis.available()];
        fis.read(file2Content);

        FileOutputStream fos = new FileOutputStream(cleanFile);
        fos.write(file2Content);
        fos.write(file1Content);

        reader.close();
        fis.close();
        fos.close();
    }
}