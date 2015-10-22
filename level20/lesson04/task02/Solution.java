package com.javarush.test.level20.lesson04.task02;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {
    public static class JavaRush implements Serializable
    {
        public static final long serialVersionUID = 170501993;
        public JavaRush() {}

        public List<User> users = new ArrayList<>();
        public JavaRush(User... users) {

            if (users != null) {
                this.users.addAll(Arrays.asList(users));
            }
        }
    }
}
