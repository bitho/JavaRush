package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String res = "";
        while (fileReader.ready()){

            String[] mas = fileReader.readLine().split(" ");
            for (String el : mas){
                if (el.length() > 6)  res += el + ",";
            }
            if (!fileReader.ready()){
                res = res.substring(0,res.length()-1);
            }

        }if (!res.equals("")) fileWriter.write(res);
        fileReader.close();
        fileWriter.close();
    }
}