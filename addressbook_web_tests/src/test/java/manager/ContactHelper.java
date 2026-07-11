package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {

    private final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void createContact(ContactData contact) {
        openHomePage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middleName());
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager.driver.findElement(By.name("work")).sendKeys(contact.work());
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("email2")).sendKeys(contact.email2());
        manager.driver.findElement(By.name("email3")).sendKeys(contact.email3());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public void removeContact() {
        openHomePage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("selected[]"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }



}

