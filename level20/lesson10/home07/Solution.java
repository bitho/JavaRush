package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String filename;
    private static final long serialVersionUID=11111111;
    public Solution(String fileName) throws FileNotFoundException {
        filename = fileName;
        stream = new FileOutputStream(filename);
    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(filename, true);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
    //for testing
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("C:\\forJavaRush\\formain.txt");
        sol.writeObject("eeeeee");
        System.out.println(sol.stream);
//save to file


        FileOutputStream fos = new FileOutputStream("C:\\forJavaRush\\formain1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        oos.close();
        fos.close();


        //load from file
        FileInputStream fis = new FileInputStream("C:\\forJavaRush\\formain1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution sol2 = (Solution) ois.readObject();
        ois.close();
        System.out.println(sol2.stream);
        sol2.writeObject("wwwwwwww");
    }
}