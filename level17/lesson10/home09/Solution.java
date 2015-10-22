package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {


            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();

            BufferedReader firstFilereader = new BufferedReader(new FileReader(firstFileName));
            BufferedReader secondFilereader = new BufferedReader(new FileReader(secondFileName));

            String firstFileline;
            String secondFileline;

            while ((firstFileline = firstFilereader.readLine()) != null)
            {
                allLines.add(firstFileline);
            }
            firstFilereader.close();

            while ((secondFileline = secondFilereader.readLine()) != null)
            {
                forRemoveLines.add(secondFileline);
            }
            secondFilereader.close();

            Solution solution = new Solution();
            solution.joinData();
        }
        catch (Exception e){

        }
    }

    public void joinData () throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}