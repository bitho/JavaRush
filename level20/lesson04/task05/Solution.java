package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
        private static final long serialVersionUID = 154L;
    }

    public static void main(java.lang.String[] args) throws Exception
    {
        FileOutputStream fileOutputStream = new FileOutputStream("file.tmp");
        FileInputStream fileInputStream = new FileInputStream("file.tmp");
        ObjectOutputStream outputStreamObj = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream inputStreamObj = new ObjectInputStream(fileInputStream);

        Object originalObj = new Object();
        originalObj.string1 = new String();
        originalObj.string2 = new String();
        outputStreamObj.writeObject(originalObj);

        java.lang.Object rawObj = inputStreamObj.readObject();
        Object restoredObject = (Object) rawObj;

        originalObj.string1.print();
        originalObj.string2.print();
        restoredObject.string1.print();
        restoredObject.string2.print();

        System.out.println(originalObj);
        System.out.println(restoredObject);
    }

    public static int countStrings;

    public static class String implements Serializable {
        private static final long serialVersionUID = 154L;
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
