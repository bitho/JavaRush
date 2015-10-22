package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution
{
    public static final long serialVersionUID = 170501993;
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Human newHuman = new Human();

        FileOutputStream fileOutputStream = new FileOutputStream("object.tmp");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(newHuman);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("object.tmp");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object loadedHumanAsObj = inputStream.readObject();
        fileInputStream.close();
        inputStream.close();

        Human loadedHuman = (Human) loadedHumanAsObj;
    }
}