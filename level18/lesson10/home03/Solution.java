package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
public static void main(String[] args) throws IOException
{
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
FileOutputStream out = new FileOutputStream(reader.readLine());
FileInputStream in1 = new FileInputStream(reader.readLine());
FileInputStream in2 = new FileInputStream(reader.readLine());
reader.close();
byte[] mas1 = new byte[in1.available()];
byte[] mas2 = new byte[in2.available()];
int count1 = in1.read(mas1);
int count2 = in2.read(mas2);

out.write(mas1,0,count1);
out.write(mas2,0,count2);
in1.close();
in2.close();
out.close();

}
}