package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static class Human
    {

        public String name;
        public int age;
        public boolean sex;
        public Human father;
        public Human mother;
        public boolean conviction;

        public Human(String name, Human father, boolean sex, Human mother)
        {
            this.name = name;
            this.father = father;
            this.sex = sex;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother, boolean conviction)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
            this.conviction = conviction;
        }

        public Human(String name, boolean sex, Human father, Human mother, boolean conviction)
        {
            this.name = name;
            age = 0;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
            this.conviction = conviction;
        }

        public Human(String name, Human father, Human mother, boolean conviction)
        {
            this.name = name;
            age = 0;
            sex = true;
            this.father = father;
            this.mother = mother;
            this.conviction = conviction;
        }

        public Human(String name, Human mother, boolean conviction)
        {
            this.name = name;
            this.mother = mother;
            this.conviction = conviction;
        }

        public Human(String name, boolean conviction)
        {
            this.name = name;
            this.conviction = conviction;
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, boolean conviction)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.conviction = conviction;
        }
    }
}