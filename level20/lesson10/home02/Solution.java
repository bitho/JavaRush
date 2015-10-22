package com.javarush.test.level20.lesson10.home02;

import java.io.*;
import java.io.ObjectInputStream;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable { //Пробовал и без implements Serializable, но также не принимает
    private static final long serialVersionUID = 1L;
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        try {
            a = (A) objectStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (a instanceof B)
            return (B) a;
        else
            return a;
    }

    public class A implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}