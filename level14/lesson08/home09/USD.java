package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Александр on 05.09.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {super(amount);
        //amount = amount;
    }
    public String getCurrencyName()
    {
        return "USD";
    }
}
