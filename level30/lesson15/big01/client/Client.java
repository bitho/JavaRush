package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Александр on 20.10.2015.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Please write IP");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Please write port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Please write your name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Connection error");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Wait error");
            return;
        }
        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected)
        {
            String message;
            if (!(message = ConsoleHelper.readString()).equals("exit"))
            {
                if (shouldSentTextFromConsole())
                {
                    sendTextMessage(message);
                }
            } else
            {
                return;
            }
        }
    }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName);
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName);
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                String type = message.getType().toString();
                switch (type){
                    case "NAME_REQUEST":
                {
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                }
                    break;
                    case "NAME_ACCEPTED":
                {
                    notifyConnectionStatusChanged(true);
                    return;
                }

                    default:
                {
                    throw new IOException("Unexpected MessageType");
                }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                String type = message.getType().toString();
                switch (type)
                {
                    case "TEXT": processIncomingMessage(message.getData());
                        break;
                    case "USER_ADDED": informAboutAddingNewUser(message.getData());
                        break;
                    case "USER_REMOVED": informAboutDeletingNewUser(message.getData());
                        break;
                    default: throw new IOException("Unexpected MessageType");

                }
            }
        }

        @Override
        public void run()
        {
            try
            {
                String address = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }
}