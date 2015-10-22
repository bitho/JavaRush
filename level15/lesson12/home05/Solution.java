package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {


    public Solution(long size)
    {

    }
    public Solution(int age, boolean sex)
    {

    }
    public Solution(boolean sex, int age)
    {

    }
    protected Solution(String name)
    {

    }
    protected Solution(int age, String name)
    {

    }
    protected Solution(int age)
    {


    }
    Solution(String name, long size)
    {

    }
    Solution(String name, int age, long size)
    {

    }
    Solution(long size, int age)
    {


    }
    private Solution(String name, double weght)
    {


    }
    private Solution(String name, int age, double weght)
    {


    }
    private Solution(double weght, int age)
    {



    }

}

