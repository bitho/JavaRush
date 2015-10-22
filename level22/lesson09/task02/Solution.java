package com.javarush.test.level22.lesson09.task02;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        if (params.isEmpty() || params == null)
            return new StringBuilder();

        StringBuilder builder = new StringBuilder("");
        Object[] keys = params.keySet().toArray();
        boolean isFirst = true;
        for (int i = 0; i <keys.length; i++)
        {
            String key = (String) keys[i];
            String value = params.get(key);

            if (value == null)
                continue;

            if (!isFirst)
                builder.append(" and ");
            else isFirst = false;
            builder.append(String.format("%s = \'%s\'", key, value));




        }

        return builder;
    }



}
