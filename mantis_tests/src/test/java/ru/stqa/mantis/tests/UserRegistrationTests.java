package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    @Test
    void canRegisterUser() {
        var username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesApi().addUser(email, password);
        app.rest().register(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var url = app.mail().extractUrl(messages.get(0));
        //System.out.println("URL: " + url);
        app.mantis().openVerificationUrl(url);
        app.mantis().finishRegistration(password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}