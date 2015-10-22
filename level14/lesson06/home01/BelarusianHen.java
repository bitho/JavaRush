package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Александр on 05.09.2015.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 4000;
    }
    String getDescription()
    {
        return super.getDescription()  + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
