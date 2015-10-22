package com.javarush.test.level22.lesson05.task01;

import java.util.*;
import java.util.regex.*;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null || string.isEmpty() || !string.contains(" ") || string.length() < 5)
            throw new TooShortStringException();

        String regex = "\\s\\S*\\s\\S*\\s\\S*\\s\\S*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (!matcher.find()) throw new TooShortStringException();

        return string.substring(string.indexOf(" ") + 1, matcher.end());
    }

    public static class TooShortStringException extends Exception{
    }


}