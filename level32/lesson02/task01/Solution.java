package com.javarush.test.level32.lesson02.task01;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

//        String fileName = "1.txt";
//        long number = 232;
//        String text = "Hello Ololo";

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        if (raf.length()<number)
        {
            raf.seek(raf.length());
            raf.writeBytes(text);
        }
        else
        {
            raf.seek(number);
            raf.writeBytes(text);
        }
    }
}