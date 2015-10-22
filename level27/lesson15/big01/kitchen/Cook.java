package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by Александр on 10.10.2015.
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable tablet, Object order)
    {
        System.out.println("Start cooking - " + ((Order) order).toString() + ", cooking time " + ((Order) order).getTotalCookingTime() + "min");
        CookedOrderEventDataRow event = new CookedOrderEventDataRow(tablet.toString(), this.name, ((Order) order).getTotalCookingTime() * 60, ((Order) order).getDishes());
        StatisticManager.getInstance().register(event);
        setChanged();
        notifyObservers(order);

    }
}