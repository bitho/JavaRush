package com.javarush.test.level28.lesson15.big01;




/**
 * Created by Александр on 09.10.2015.
 */

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller
{
    private Model model;

    public Controller(Model model) {
        if (model == null) throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }



    /*private Provider[] providers;

    public Controller(Provider... providers)
    {
        if (providers==null||providers.length==0)
        {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }*/

    /*@Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }*/


    /*public void scan()
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        try
        {
            for (Provider it : providers)
            {
                for (Vacancy iter : it.getJavaVacancies("Kiev"))
                {
                    vacancyList.add(iter);
                }
            }
        }
        catch (NullPointerException e)
        {}
        System.out.println(vacancyList.size());
    }*/
}