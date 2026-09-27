package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.manager.ApplicationManager;
import ru.stqa.mantis.manager.HelperBase;

public class UserRegistrationTests extends HelperBase {

    public UserRegistrationTests(ApplicationManager manager) {
        super(manager);
    }

    @Test
    void canRegisterUser(String username) {
        var email = String.format("%s@localhost", username);
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания и отправляем (браузер) - создать класс помощник
        // ждем почту (MailHelper)
        // извлекаем ссылку из письма (canExtractUrl)
        // проходим по ссылке и завершаем регистрацию пользователя (браузер) - создать класс помощник
        // проверяем, что пользователь может залогиниться (HttpSessionHelper)
    }
}
