package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Александр on 06.09.2015.
 */
public class TeaMaker extends DrinkMaker
{
    void getRightCup(){
        System.out.println("Берем чашку для чая");
    }
    void putIngredient(){
        System.out.println("Насыпаем чай");
    }
    void pour(){
        System.out.println("Заливаем водой");
    }
}