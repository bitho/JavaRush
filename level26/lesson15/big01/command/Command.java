package com.javarush.test.level26.lesson15.big01.command;

/**
 * Created by Александр on 10.10.2015.
 */
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;



interface Command
{
    public void execute() throws InterruptOperationException;
}