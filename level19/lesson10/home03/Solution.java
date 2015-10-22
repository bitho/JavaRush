package com.javarush.test.level19.lesson10.home03;

import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.text.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String fileName = args[0];
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            while (reader.ready())
            {


                String [] s = reader.readLine().split(" ");
                int sz = s.length;

                if(sz>3)
                {

                    String d = s[sz - 3] + " " + s[sz - 2] + " " + s[sz - 1];
                    Date date = new SimpleDateFormat("dd MM yyyy").parse(d);

                    StringBuilder name = new StringBuilder();

                    for (int i = 0; i < sz - 3; i++)
                        name.append(s[i] + " ");


                    PEOPLE.add(new Person(name.toString().trim(), date));
                }




            }

            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
        catch (IOException e)
        {

        }
        catch (ParseException e)
        {

        }


    }

}
