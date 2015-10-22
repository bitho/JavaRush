package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Александр on 10.10.2015.
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public final class CurrencyManipulatorFactory
{
    static Map<String, CurrencyManipulator> manipulators= new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if(!manipulators.containsKey(currencyCode)){
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);
    }

}