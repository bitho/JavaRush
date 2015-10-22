package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception{

        byte [] key = {74,65,86,65};
        try {
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);
            byte[] data = new byte [in.available()];
            int count = 0;
            if (in.available()>0) {
                count =  in.read(data);
            }
            if (args[0].equals("-e")){
                // зашифровка
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (data[i] ^ key[i % key.length]);
                }
                if (count!= 0) {
                    out.write(data, 0 , count);
                }
            }
            else {
                if (args[0].equals("-d")){
                    // дешифровка
                    for (int i = 0; i < data.length; i++) {
                        data[i] = (byte) (data[i] ^ key[i % key.length]);
                    }
                    if (count!= 0) {
                        out.write(data, 0 , count);
                    }
                }
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}