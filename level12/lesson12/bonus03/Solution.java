package com.javarush.test.level12.lesson12.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }
        int[] array1 = new int[array.length];
        array1 = array.clone();
        for (int i = 0; i < array1.length - 1; i++)
        {
            for (int j = 0; j < array1.length - 1; j++)
            {
                if (array1[j]>array1[j+1])
                {
                    int tmp = array1[j];
                    array1[j] = array1[j+1];
                    array1[j+1] = tmp;
                }
            }
        }
        int indexMin = 0;
        for (int k = 0; k < array.length; k++)
        {
            if (array[k]==array1[0]) indexMin = k;
        }

        return new Pair<Integer, Integer>(array1[0], indexMin);
    }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
