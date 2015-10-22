package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
    }
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public static void main(String[] args) {
        Cat tom = new Cat();
        cats.add(tom);
        Cat sam = new Cat();
        cats.add(sam);
        Cat bill = new Cat();
        cats.add(bill);
        Cat bob = new Cat();
        cats.add(bob);
        Cat com = new Cat();
        cats.add(com);
        Cat sil = new Cat();
        cats.add(sil);
        Cat rur = new Cat();
        cats.add(rur);
        Cat mok = new Cat();
        cats.add(mok);
        Cat lom = new Cat();
        cats.add(lom);
        Cat kirk = new Cat();
        cats.add(kirk);

        printCats();
    }

    public static void printCats() {

        //for (int i = 0; i < 10; i++)
        System.out.println(cats);

    }
}
