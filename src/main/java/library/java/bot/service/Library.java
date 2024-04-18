package library.java.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class Library extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "library_ldubgd_bot";
    }

    @Override
    public String getBotToken() {
        return "5957300741:AAGg2Gvdb2lDJWTPG6Zu5Ibq3r3oWRBZHEo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println("Повідомлення від користувача: " + message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Будь ласка, оберіть Вашу спеціальність.");
        sendMessage.setChatId(String.valueOf(message.getChatId()));


        if (message.getText().equals("/start")){
            String text ="Вітаю! Це бібліотека ЛДУ БЖД. Тут Ви можете знайти книги для Вашої спеціальності.\n";
            text = text + "Оберіть спеціальність, на якій навчаєтесь)\n";

            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getBooksKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);
            sendMessage.setText(text);

        }
        if (message.getText().equals("Кібербезпека")){
            String books = "Книги для студентів кібербезпеки:\n";
            books = books + "1. Хакінг: мистецтво експлойта, 496 стор. 2019 рік \n";
            books = books + "2. Кібербезпека цифрової економіки для власників бізнесу, 2019 рік.\n";
            books = books + "3. Безпечна мережа. Правила збереження репутації в епоху соціальних медіа і тотальної публічності. 214 стр. 2016 рік. \n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Комп'ютерні науки")){
            String books = "Книги для студентів комп'ютерних наук:\n";
            books = books + "1. Ефективна робота з успадкованим кодом (Майкл Фізерс)\n";
            books = books + "2. Head First. Паттерни проектування\n";
            books = books + "3. Алгоритми на Java (Роберт Седжвік, Кевін Вейн)\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Екологія")){
            String books = "Книги для студентів екології:\n";
            books = books + "1. Дім-нуль відходів Беа Джонсон (Рідна мова, 2019)\n";
            books = books + "2. Сміття і люди. Зворотній бік споживання Томас Гілланд Еріксен (Ніка-Центр, 2016)\n";
            books = books + "3. Нехай буде вода. Ізраїльський досвід вирішення світової проблеми нестачі води\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Цивільна безпека")){
            String books = "Книги для студентів цивільної безпеки:\n";
            books = books + "1. Книга Цивільна безпека Батир Халмурадов, Валерій Михайлюк\n";
            books = books + "2. Практикум з безпеки життєдіяльності\n";
            books = books + "3. Цивільний захист України. Навчальний посібник для студентів вищих навчальних закладів\n";

            sendMessage.setText(books);

        }

        try {
            execute(sendMessage);
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }


   }
   private ReplyKeyboardMarkup getBooksKeyboard(){
       ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
       replyKeyboardMarkup.setSelective(true);
       replyKeyboardMarkup.setResizeKeyboard(true);
       replyKeyboardMarkup.setOneTimeKeyboard(false);

       List<KeyboardRow> keyboardRows = new ArrayList<>();
       KeyboardRow keyboardRow = new KeyboardRow();
       keyboardRow.add("Кібербезпека");
       keyboardRow.add("Комп'ютерні науки");
       KeyboardRow keyboardSecondRow = new KeyboardRow();
       keyboardSecondRow.add("Екологія");
       keyboardSecondRow.add("Цивільна безпека");
       keyboardRows.add(keyboardRow);
       keyboardRows.add(keyboardSecondRow);

       replyKeyboardMarkup.setKeyboard(keyboardRows);
       return replyKeyboardMarkup;
   }
}
