package com.javarush.test.level05.lesson07.task01;

/**
 * Created by Александр on 15.08.2015.
 */
public class Friend
{

    private String name = null;
    private int age = 0;
    private String sex = null;



        public void initialize(String name){
        this.name = name;
    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void initialize(String name, int age, String sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public static void main(String[] args){

        Friend f1 = new Friend();
        f1.initialize("Vaska");
        Friend f2 = new Friend();
        f2.initialize("Sam",34);
        Friend f3 = new Friend();
        f3.initialize("Moby",23,"муж");
    }
}
