package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class MantisHelper extends HelperBase {

    public MantisHelper(ApplicationManager manager) {
        super(manager);
    }

    public void startRegistration() {
        manager.driver().get(manager.property("web.baseUrl") + "/login_page.php");
        click(By.linkText("Signup for a new account"));
    }

    public void register(String username, String email) {
        type(By.id("username"), username);
        type(By.id("email-field"), email);
        click(By.cssSelector("input[type='submit'][value='Signup']"));
    }

    public void openVerificationUrl(String url) {
        manager.driver().get(url);
    }

    public void finishRegistration(String password) {
        type(By.id("password"), password);
        type(By.id("password-confirm"), password);
        click(By.cssSelector("button[type='submit']"));
    }
}