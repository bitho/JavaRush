package com.javarush.test.level04.lesson16.level05.lesson05.task02;

/**
 * Created by Александр on 15.08.2015.
 */

    /* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

    public class CatsFight
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public CatsFight(String name, int age, int weight, int strength)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(CatsFight anotherCat)
    {
        int iAge = 0;
        int iWeight = 0;
        int iStrength = 0;
        int sum = 0;

        if      (this.age > anotherCat.age)  iAge = 1;
        else if (this.age < anotherCat.age)  iAge = -1;
        else if (this.age == anotherCat.age) iAge = 0;
        if      (this.weight > anotherCat.weight) iWeight = 3;
        else if (this.weight < anotherCat.weight) iWeight = -3;
        else if (this.weight == anotherCat.weight) iWeight = 0;
        if      (this.strength > anotherCat.strength)  iStrength = 5;
        else if (this.strength < anotherCat.strength) iStrength = -5;
        else if (this.strength == anotherCat.strength) iStrength = 0;

        sum = iAge + iWeight + iStrength;
        return (sum > 0);


    }

    public static void main(String[] args)
    {
        CatsFight catVaska = new CatsFight("Vaska", 11, 2, 10);
        CatsFight catBardic = new CatsFight("Bardik", 10, 5, 9);

        System.out.println(catVaska.fight(catBardic));
        System.out.println(catBardic.fight(catVaska));
    }
}
