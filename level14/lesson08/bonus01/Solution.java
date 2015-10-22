package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static void main(String[] args)
    {
        initExceptions();
        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }
    private static void initExceptions()
    /*{   //it's first exception
        try
        {
            float i = 1 / 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.contains(a.get(0));
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Integer test = null;
            Integer test2 = 0;
            test2.sum(test, test2);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String test = "test";
            int test2 = Integer.parseInt(test);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String test = "test";
            char test2 = test.charAt(100);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object i[] = new String[0];
            i[1] = new Integer(0);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object i = new Integer(0);
            System.out.print((String) i);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Solution test = new Solution();
            test.clone();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String s = "sdfsdf";
            int f = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here
    }*/
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                float f = 1 / 0;
            }
            catch (Exception e)
            {
                exceptions.add(e);
            }
        }
    }
}