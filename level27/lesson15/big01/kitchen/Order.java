package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    List<Dish> getDishes(){
        return this.dishes;
    }

    @Override
    public String toString()
    {
        if (dishes.size() == 0) return "";
        return String.format("Your order: %s of %s", dishes, tablet);
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Dish dish : dishes)
            totalTime += dish.getDuration();
        return totalTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}