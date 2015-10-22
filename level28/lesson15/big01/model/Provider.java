package com.javarush.test.level28.lesson15.big01.model;




/**
 * Created by Александр on 09.10.2015.
 */

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;


public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString)
    {

        return strategy.getVacancies(searchString);
    }
}