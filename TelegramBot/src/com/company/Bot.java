package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "1060126294:AAH1KIRvf40UjlUXQDPvkdqbt2BBggZCydk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        if(update.getMessage().getText().equals("Привет")) {
            sendMessage.setText("Привет дружище! Введи два числа...");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            String data = update.getMessage().getText();
            String[] arrayData = data.split(" ");
            int[] digits = new int[arrayData.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(arrayData[i]);
            }
            int result = digits[0] + digits[1];
            sendMessage.setText("" + result);


        }
    }

    @Override
    public String getBotUsername() {
        return "simple_test_241119_bot";
    }
}
