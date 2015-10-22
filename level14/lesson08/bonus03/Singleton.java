package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Александр on 05.09.2015.
 */
public class Singleton
{
    private Singleton()
    {

    }
    private static Singleton singleton = new Singleton();
    static Singleton getInstance()
    {
        return singleton;
    }
}
