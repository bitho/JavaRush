package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {

        List<String> name_of_files = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String fileName;
        while (!(fileName = in.nextLine()).equals("end"))
        {
            name_of_files.add(fileName);
        }
        in.close();

        Collections.sort(name_of_files);
        int partCount = name_of_files.size();

        String nameFileForWrite = name_of_files.get(0).replace(".part1", "");
        FileOutputStream fileForWrite = new FileOutputStream(nameFileForWrite);

        for (int i = 1; i <= partCount; i++)
        {
            String file_part_name = nameFileForWrite.concat(".part") + i;
            System.out.println(file_part_name);

            FileInputStream fileInputStream = new FileInputStream(file_part_name);
            byte[] temp = new byte[fileInputStream.available()];
            fileInputStream.read(temp);
            fileInputStream.close();

            fileForWrite.write(temp);
            fileForWrite.flush();
        }
        fileForWrite.close();
    }
}