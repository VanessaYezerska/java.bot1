package library.java.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
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
        sendMessage.setText("Будь ласка, оберіть потрібний варіант:");
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.getText().equals("/start")) {
            String text = "Вітаю! Це бібліотека ЛДУ БЖД. Тут Ви можете знайти рекомендовані книги для Вашої спеціальності.\n";
            text = text + "Оберіть інститут :)\n";

            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getBooksKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);
            sendMessage.setText(text);

        }
        else if (message.getText().equals("Навчально-науковий інститут цивільного захисту")) {
            // Отримано команду "Інститут цивільного захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForCivilProtection();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }else if (message.getText().equals("Навчально-науковий інститут психології та соціального захисту")) {
            // Отримано команду "Інститут психології та соціального захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForPsychologyAndSocialProtection();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }else if (message.getText().equals("Навчально-науковий інститут пожежної та техногенної безпеки")) {
            // Отримано команду "Інститут психології та соціального захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForFireAndTechnogenicSafety();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }


        if (message.getText().equals("Назад")){
            String a = "Оберіть інститут:";
            ReplyKeyboardMarkup keyboardMarkup = getBooksKeyboard();
            sendMessage.setText(a);
            sendMessage.setReplyMarkup(keyboardMarkup);
        }
        if (message.getText().equals("Кібербезпека")) {
            String books = "Книги для студентів кібербезпеки:\n";
            books = books + "1. Хакінг: мистецтво експлойта, 496 стор. 2019 рік \n";
            books = books + "2. Кібербезпека цифрової економіки для власників бізнесу, 2019 рік.\n";
            books = books + "3. Безпечна мережа. Правила збереження репутації в епоху соціальних медіа і тотальної публічності. 214 стр. 2016 рік. \n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Комп'ютерні науки")) {
            String books = "Книги для студентів комп'ютерних наук:\n";
            books = books + "1. Ефективна робота з успадкованим кодом (Майкл Фізерс)\n";
            books = books + "2. Head First. Паттерни проектування\n";
            books = books + "3. Алгоритми на Java (Роберт Седжвік, Кевін Вейн)\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Екологія")) {
            String books = "Книги для студентів екології:\n";
            books = books + "1. Дім-нуль відходів Беа Джонсон (Рідна мова, 2019)\n";
            books = books + "2. Сміття і люди. Зворотній бік споживання Томас Гілланд Еріксен (Ніка-Центр, 2016)\n";
            books = books + "3. Нехай буде вода. Ізраїльський досвід вирішення світової проблеми нестачі води\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Цивільна безпека")) {
            String books = "Книги для студентів цивільної безпеки:\n";
            books = books + "1. Книга Цивільна безпека Батир Халмурадов, Валерій Михайлюк\n";
            books = books + "2. Практикум з безпеки життєдіяльності\n";
            books = books + "3. Цивільний захист України. Навчальний посібник для студентів вищих навчальних закладів\n";

            sendMessage.setText(books);

        }if (message.getText().equals("Психологія")) {
            String books = "Книги для студентів психології:\n";
            books = books + "1. Юридична психологія,Александров Д.О., Андросюк В.Г., Казміренко Л.І. ,2007\n";
            books = books + "2. Психологія праці,Баклицький І.О.,2004\n";
            books = books + "3. Експериментальна психологія,Баклицький І.О., Сірко Р.І.,2011\n";
            books = books + "4. Психологія людини з обмежиними можливостями,Бочелюк В.Й., Турубарова А.В.,2011\n";
            books = books + "5. Соціальна психологія в рекламі,Бутенко Н.Ю.,2006\n";
            books = books + "6. Загальна психологія,Варій М.Й.,2007\n";
            books = books + "7. Психологія особистості,Варій М.Й.,2008\n";
            books = books + "8. Психологія,Варій М.Й.,2009\n";
            books = books + "9. Психологія спілкування,Вашека Т.В., Гічан І.С.,2006\n";
            books = books + "10. Соціальна психологія,Волянська О.В., Ніколаєвська А.М.,2008\n";
            books = books + "11. Соціальна психологія,Волянська О.В., Ніколаєвська А.М.,2008\n";
            books = books + "12. Психологія конфлікту,Долинська Л.В., Матяш-Заяц Л.П.,2010\n";
            books = books + "13. Дошкільна психологія,Дуткевич Т.В.,2007\n";
            books = books + "14. Психологія мотивації,Занюк С.С.,2002\n";
            books = books + "15. Психологія конфлікту,Долинська Л.В., Матяш-Заяц Л.П.,2010\n";

            sendMessage.setText(books);

        }




        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }


    private ReplyKeyboardMarkup getNewKeyboardForFireAndTechnogenicSafety() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Менеджмент");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Пожежна безпека");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Транспортні технології");
        keyboardRows.add(keyboardRow3);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getNewKeyboardForPsychologyAndSocialProtection() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Психологія");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Соціальна робота");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Філологія");
        keyboardRows.add(keyboardRow3);

        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add("Професійна освіта");
        keyboardRows.add(keyboardRow4);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
    private ReplyKeyboardMarkup getNewKeyboardForCivilProtection() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Комп'ютерні науки");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Кібербезпека");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Екологія");
        keyboardRows.add(keyboardRow3);

        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add("Цивільна безпека");
        keyboardRows.add(keyboardRow4);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }


    private ReplyKeyboardMarkup getBooksKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Навчально-науковий інститут цивільного захисту");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Навчально-науковий інститут психології та соціального захисту");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Навчально-науковий інститут пожежної та техногенної безпеки");
        keyboardRows.add(keyboardRow3);


        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }



}
любимка придатко і срана курсова
