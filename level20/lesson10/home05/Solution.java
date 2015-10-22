package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.io.PrintStream;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person1 = new Person("Vasya", "Popov", "Ukraine", Sex.MALE);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(out);
        stream.writeObject(person1);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream is = new ObjectInputStream(in);
        Person person2 = (Person)is.readObject();

        System.out.println(person2.firstName + " " + person2.fullName + " " + person2.sex + " " + person2.country + " " +
                person2.logger + " " + person2.greetingString);
    }
    public static class Person implements Serializable {
        public static final long serialVersionUID = 170501993;
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;


        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}