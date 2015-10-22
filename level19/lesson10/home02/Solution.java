package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner=new Scanner(new File(args[0]), "utf8");
        String name="";
        Double money;
        String string;
        HashMap<String, Double>map=new HashMap<String, Double>();
        while (scanner.hasNext()){
            string=scanner.nextLine();
            name=string.substring(0, string.indexOf(" "));
            money=Double.parseDouble(string.substring(string.indexOf(" ")+1));
            if(map.containsKey(name)) map.put(name, map.get(name)+money);
            else map.put(name, money);
        }
        money=0.0d;
        ArrayList<String>list=new ArrayList<String>();  //для записи самых богатых
        for(Map.Entry<String, Double>pair: map.entrySet()){
            if(pair.getValue()>money){
                money=pair.getValue();
                list.clear();
                list.add(pair.getKey());
            }
            else if(pair.getValue().equals(money)) {
                list.add(pair.getKey());
            }
        }
        for (String nameBigMoney:list){
            System.out.print(nameBigMoney+" ");
        }
        scanner.close();
    }
}
