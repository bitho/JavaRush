package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new  ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String st = outputStream.toString();
        st = st.replace("\r\n", "");
        ArrayList<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher matcher = p.matcher(st);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        int solution = 0;
        if (st.contains("+")) {
            solution = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1));
        }
        if (st.contains("-")) {
            solution = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1));
        }
        if (st.contains("*")) {
            solution = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1));
        }
        System.setOut(consoleStream);
        System.out.println(st + String.valueOf(solution));
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}