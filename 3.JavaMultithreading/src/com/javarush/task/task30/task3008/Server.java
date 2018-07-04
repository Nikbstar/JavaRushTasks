package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Сервер запущен.");
            while (true) {
                Socket socket = ss.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {

        private Socket socket;

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message receiveName;
            String clientName;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                receiveName = connection.receive();
                clientName = receiveName.getData();
                if (receiveName.getType() == MessageType.USER_NAME
                        && !clientName.isEmpty()
                        && !connectionMap.containsKey(clientName)) {
                    connectionMap.put(clientName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    break;
                }
            }
            return clientName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    String text = String.format("%s: %s", userName, receive.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("Wrong message type (must be TEXT)");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с " + this.socket.getRemoteSocketAddress());
            String newClientName = null;
            try (Connection connection = new Connection(this.socket)) {
                newClientName = this.serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClientName));
                sendListOfUsers(connection, newClientName);
                serverMainLoop(connection, newClientName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }
            if (newClientName != null && !newClientName.isEmpty()) {
                connectionMap.remove(newClientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClientName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресатом закрыто!");
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }

    }

}
