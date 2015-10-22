package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 10.10.2015.
 */
public class ConsoleHelper
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String dish;
        List<Dish> listOfDishes = new ArrayList<>();
        writeMessage("Choose the dish: ");
        writeMessage(Dish.allDishesToString());
        while (!(dish = readString()).toLowerCase().equals("exit")) {
            try {
                listOfDishes.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                writeMessage(dish + " is not detected");
            }
        }
        return listOfDishes;
    }
}