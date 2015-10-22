package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Александр on 09.10.2015.
 */



public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String dishes = "";
        if (Dish.values().length == 0) return "";
        for (Enum e : Dish.values())
            dishes = dishes + e + ", ";
        //dishes = dishes.trim();
        return dishes.substring(0, dishes.length() - 2);
    }

    public int getDuration()
    {
        return duration;
    }

}