package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children3 = new ArrayList<Human>();
        ArrayList<Human> children4 = new ArrayList<Human>();
        ArrayList<Human> children5 = new ArrayList<Human>();
        Human son1 = new Human("Son1", true, 14, children3);
        Human son2 = new Human("Son2", true, 21, children4);
        Human daughter1 = new Human("Doch1", false, 26, children5);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(son1);
        children.add(son2);
        children.add(daughter1);
        Human father = new Human("Otec", true, 43, children);
        Human mother = new Human("Mat", false, 42, children);
        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(father);
        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(mother);
        Human granf1 = new Human("Ded1", true, 78, children1);
        Human granf2 = new Human("Ded2", true, 80, children2);
        Human granm1 = new Human("Babka1", false, 84, children1);
        Human granm2 = new Human("Babka2", false, 82, children2);

        System.out.println(granf1.toString());
        System.out.println(granf2.toString());
        System.out.println(granm1.toString());
        System.out.println(granm2.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(daughter1.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
