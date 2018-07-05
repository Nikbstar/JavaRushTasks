package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndMessage = message.split(": ", 2);
            if (nameAndMessage.length == 2) {
                String datePattern = "";
                boolean needAnswer = true;
                switch (nameAndMessage[1]) {
                    case "дата": datePattern = "d.MM.YYYY";
                        break;
                    case "день": datePattern = "d";
                        break;
                    case "месяц": datePattern = "MMMM";
                        break;
                    case "год": datePattern = "YYYY";
                        break;
                    case "время": datePattern = "H:mm:ss";
                        break;
                    case "час": datePattern = "H";
                        break;
                    case "минуты": datePattern = "m";
                        break;
                    case "секунды": datePattern = "s";
                        break;
                    default: needAnswer = false;
                        break;
                }
                if (needAnswer) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
                    Calendar date = Calendar.getInstance();
                    
                    String result = String.format("Информация для %s: %s", nameAndMessage[0], dateFormat.format(date.getTime()));
                    sendTextMessage(result);
                }
            }
        }
    }

}
