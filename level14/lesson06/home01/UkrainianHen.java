package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Александр on 05.09.2015.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 8000;
    }
    String getDescription()
    {
        return super.getDescription()  + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
