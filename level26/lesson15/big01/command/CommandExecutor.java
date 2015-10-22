package com.javarush.test.level26.lesson15.big01.command;

/**
 * Created by Александр on 10.10.2015.
 */
import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;


public  class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();

    private CommandExecutor()
    {
    }

    static {
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {

        map.get(operation).execute();
    }
}
