package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by Александр on 09.10.2015.
 */
import com.javarush.test.level31.lesson15.big01.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}