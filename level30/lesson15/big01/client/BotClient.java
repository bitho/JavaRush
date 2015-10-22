package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Александр on 20.10.2015.
 */
public class BotClient extends Client
{
    private static volatile int botNumber = 0;
    private String userName = null;
    public BotClient(){
        botNumber++;
        if (botNumber>=100)botNumber = 0;
        if (botNumber>=0 && botNumber<=9)
            this.userName = "date_bot_0" + botNumber;
        else if (botNumber>=10 && botNumber<=99)
            this.userName = "date_bot_" + botNumber;
    }

    @Override
    protected BotSocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return this.userName;
    }


    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, " +
                    "месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
        @Override
        protected void processIncomingMessage(String message){
            String[] nameAndText = new String[2];
            nameAndText[0] = message.substring(0, message.indexOf(": "));
            nameAndText[1] = message.substring(message.indexOf(": ")+2);
            ConsoleHelper.writeMessage(nameAndText[1]);
            SimpleDateFormat s = null;
            if(nameAndText[1].equals("дата")) {s = new SimpleDateFormat("d.MM.YYYY");}
            if(nameAndText[1].equals("день")) {s = new SimpleDateFormat("d");}
            if(nameAndText[1].equals("месяц")) {s = new SimpleDateFormat("MMMM");}
            if(nameAndText[1].equals("год")) {s = new SimpleDateFormat("YYYY");}
            if(nameAndText[1].equals("время")) {s = new SimpleDateFormat("H:mm:ss");}
            if(nameAndText[1].equals("час")) {s = new SimpleDateFormat("H");}
            if(nameAndText[1].equals("минуты")) {s = new SimpleDateFormat("m");}
            if(nameAndText[1].equals("секунды")) {s = new SimpleDateFormat("s");}
            try
            {
                if(s != null) connection.send(new Message(MessageType.TEXT,
                        String.format("Информация для %s: %s",nameAndText[0],s.format(Calendar.getInstance().getTime()))));
            }catch (IOException e){}
        }
    }
}
