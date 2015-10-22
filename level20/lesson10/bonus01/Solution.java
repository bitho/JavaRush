package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;
import java.util.Collections;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        List<Integer> list = new ArrayList<>();

        final int NUMBERS = 10;
        final int SQRT = 12;
        long[][] arraySteps = new long[NUMBERS][SQRT];

        for (int i = 0; i < NUMBERS; i++) {
            for (int j = 0; j < SQRT; j++) {
                long temp = i;
                for (int z = 0; z < j - 1; z++) {
                    temp *= i;
                }
                arraySteps[i][j] = temp;
            }
        }

        for (int i = 1; i < N; i++) {
            long multiply = 0;
            int step = 0;


            boolean flag = false;

            int number = i;
            int ostatok = -1;


            while (number > 0) {
                if (ostatok == -1) {
                    ostatok = number % 10;
                    number = number / 10;
                    step++;
                } else if (number % 10 <= ostatok) {

                    ostatok = number % 10;
                    if (ostatok == 0) {
                        ostatok = 10;
                    }
                    number = number / 10;

                    step++;
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            long result = 0;
            for (int j = i; j > 0; j /= 10) {
                result += arraySteps[j % 10][step];
                if (result > N)break;
            }

            int length = 0;
            for (long j = result; j > 0; j /= 10) {
                multiply += arraySteps[(int)(j % 10)][step];

                length++;
            }

            if (result == multiply && step == length) {
                boolean flag2 = true;
                for (Integer num1 : list) {
                    if (num1.intValue() == result) {
                        flag2 = false;
                        break;
                    }
                }
                if (flag2) {
                    list.add((int) result);
                }
            }
        }
        int [] result = new int[list.size()];
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int[] m = getNumbers(2100000000);
        Long t1 = System.currentTimeMillis();
        for (int a : m) {
            System.out.println(a);
        }
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024d) + " Mb.");
        System.out.println("Time: " + (t1 - t0)/1000d + " sec.");
    }
}