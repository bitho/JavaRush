package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        List <String> list = new ArrayList<>();
        String aLine;
        while ((aLine=input.readLine())!=null){

            String[] array = aLine.split(" ");


            for (String anArray : array) {
                int count = 0;
                for (int j = 0; j < anArray.length(); j++) {
                    if (Character.isDigit(anArray.charAt(j)))
                        count++;
                }
                if (count > 0) list.add(anArray);

        }

        }
        for (String aList : list) fileWriter.write(aList + " ");
        input.close();
        fileWriter.close();
    }
}