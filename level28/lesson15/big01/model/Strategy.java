package com.javarush.test.level28.lesson15.big01.model;



/**
 * Created by Александр on 09.10.2015.
 */

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.*;

public interface Strategy
{
    List<Vacancy> getVacancies(String searchString);

}