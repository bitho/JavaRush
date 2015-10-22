package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Iterator<Cat> i = cats.iterator();
        Cat cat = i.next();
        i.remove();

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> setCat = new HashSet<Cat>();
        Cat cat1 = new Cat();
        setCat.add(cat1);
        Cat cat2 = new Cat();
        setCat.add(cat2);
        Cat cat3 = new Cat();
        setCat.add(cat3);
        return setCat;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat cat : cats)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {

    }
}
