package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int s = 0;
        int n1 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            String n = br.readLine();
            if (!n.equals("сумма")) {n1 = Integer.parseInt(n);}


            else if (n.equals("сумма"))
            {

                System.out.println((s));
                break;
            }
            s += n1;
        }
    }
}
