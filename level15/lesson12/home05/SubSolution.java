package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Александр on 07.09.2015.
 */
public class SubSolution extends Solution
{



    public SubSolution(long size)
    {
        super(size);

    }
    public SubSolution(int age, boolean sex)
    {
        super(age, sex);

    }
    public SubSolution(boolean sex, int age)
    {
        super(sex, age);

    }
    protected SubSolution(String name)
    {
        super(name);

    }
    protected SubSolution(int age, String name)
    {
        super(age, name);

    }
    protected SubSolution(int age)
    {
        super(age);


    }
    SubSolution(String name, long size)
    {
        super(name, size);

    }
    SubSolution(String name, int age, long size)
    {
        super(name, age, size);

    }
    SubSolution(long size, int age)
    {
        super(size, age);


    }
    private SubSolution(int age, double weght, long size)
    {
        super(size, age);

    }
    private SubSolution(String name, int age, double weght, long size)
    {
        super(size, age);

    }
    private SubSolution(double weght, int age, long size)
    {
        super(size, age);



    }

}
