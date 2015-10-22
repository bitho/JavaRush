package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        while (true)
        {
            input = Integer.parseInt(reader.readLine());
            if (input > 150) continue;
            else break;
        }


        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {



        BigInteger bigResult = BigInteger.valueOf(1);
        if (n > 0)
        {
            for (int i = 1; i <= n; i++)
            {
               BigInteger bigI = BigInteger.valueOf(i);
               bigResult = bigResult.multiply(bigI);
            }
        }
        else if (n == 0) bigResult = BigInteger.valueOf(1);
        else if (n < 0) bigResult = BigInteger.valueOf(0);

        return bigResult.toString();
    }
}

/*import java.math.*;

public class BigNumbers {
    public static void main(String args[]){
        long a, b, c;
        BigInteger d, e, f;
        a = 9223372036854775807l;
        b = a;
        c = a * b;

        d = BigInteger.valueOf(a);
        e = BigInteger.valueOf(b);
        f = d.multiply(e);

        System.out.println("(long)       " + a + " * " + b + " = " + c);
        System.out.println("(BigInteger) " + d.toString() + " * " + e.toString() + " = " + f.toString());*/

/*
public static String factorial(int n) {
    //add your code here
 if (n < 0) return "0";
    if (n == 0) return "1";
    return String.valueOf(n * Integer.parseInt(factorial(n - 1)));
}*/
