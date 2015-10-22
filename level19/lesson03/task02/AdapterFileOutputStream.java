package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;
public class AdapterFileOutputStream implements AmigoStringWriter
{
    private FileOutputStream file;

    AdapterFileOutputStream(FileOutputStream file)
    {
        this.file = file;
    }

    public void flush() throws IOException
    {
        this.file.flush();
    }

    public void writeString(String s) throws IOException
    {
        this.file.write(s.getBytes());
    }

    public void close() throws IOException
    {
        this.file.close();
    }
}