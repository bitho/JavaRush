package com.javarush.test.level31.lesson15.big01;

/**
 * Created by Александр on 09.10.2015.
 */
import com.javarush.test.level31.lesson15.big01.command.ExitCommand;
import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fullFileName = br.readLine();
        Path path = Paths.get(fullFileName);
        ZipFileManager zfm = new ZipFileManager(path);
        String fullFileName1 = br.readLine();
        Path path1 = Paths.get(fullFileName1);
        try
        {
            zfm.createZip(path1);
        }
        catch (Exception e)
        {
        }

        ExitCommand ec = new ExitCommand();
        try {ec.execute();}
        catch (Exception e){}*/

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.format("\t %d - упаковать файлы в архив", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - распаковать архив", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - просмотреть содержимое архива", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}