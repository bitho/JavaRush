package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null)
            throw new TooShortStringException();


        if (string.isEmpty())
            throw new TooShortStringException();

        int one = string.indexOf('\t');
        int two = string.indexOf('\t', one+1);




        int countTab = 0;
        for (char ch : string.toCharArray())
        {
            if (ch == '\t')
            {
                countTab++;
            }
        }
        String result;
        if (countTab < 2) throw new TooShortStringException();

        result = string.substring(one + 1, two);

        return result;
    }
    public static class TooShortStringException extends Exception {
    }

}