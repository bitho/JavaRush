package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String from=reader.readLine();
        String to=reader.readLine();


        Scanner sc=new Scanner(new InputStreamReader(new FileInputStream(from)));
        FileWriter file=new FileWriter(to);


        int i=0;
        while(sc.hasNext()){
            sc.nextLine();
            i++;
        }

        Scanner sc1=new Scanner(new InputStreamReader(new FileInputStream(from)));
        String [] strings=new String[i];
        while(sc1.hasNext()){
            strings=sc1.nextLine().split(" ");

        }

        int [] mas=new int[strings.length];
        for(int s=0;s<strings.length;s++){
            mas[s]=(int)(Math.round(Double.parseDouble(strings[s])));
            file.write(String.valueOf(mas[s])+" ");
        }

        reader.close();
        sc.close();
        sc1.close();
        file.close();

    }


}