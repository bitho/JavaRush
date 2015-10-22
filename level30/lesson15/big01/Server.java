package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Александр on 19.10.2015.
 */
public class Server { private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> loop : connectionMap.entrySet()) {
            try {
                loop.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Don't send messaege to " + loop.getKey());
            }
        }
    }
    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            String name = null;
            try(Connection connection = new Connection(socket))  {//11.2.Создавать Connection, используя поле Socket
                ConsoleHelper.writeMessage("Connecting to port " + connection.getRemoteSocketAddress());//11.1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress
                name = serverHandshake(connection);//11.3.   Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));//11.4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для этого лучше всего.
                sendListOfUsers(connection, name);//11.5.   Сообщать новому участнику о существующих участниках
                serverMainLoop(connection, name);//11.6.    Запускать главный цикл обработки сообщений сервером
             } catch (IOException e) {//11.8.    Отловить все исключения типа
                ConsoleHelper.writeMessage("Error when happend exchange data");
            } catch (ClassNotFoundException e) {//11.8. Отловить все исключения типа
                ConsoleHelper.writeMessage("Error when happend exchange data");
            }
            if (name != null){
            connectionMap.remove(name);//11.9.  После того как все исключения обработаны, если п.11.3 отработал и возвратил
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));}
            ConsoleHelper.writeMessage("Connection with server is closed");//11.10. Последнее, что нужно сделать в методе run()
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    if (message.getData() != null && !message.getData().isEmpty()) {
                        if (!connectionMap.containsKey(message.getData())) {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> loop : connectionMap.entrySet()) {
                if (!userName.equals(loop.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, loop.getKey()));
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("This message don't TEXT");
                }
            }
        }
    }
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Please write server port");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server is running");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}