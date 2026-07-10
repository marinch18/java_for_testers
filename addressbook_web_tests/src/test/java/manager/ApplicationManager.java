package manager;

import model.GroupData;
import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    public static WebDriver driver;

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void openHomePage() {
        if (!isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }

    public void createContact(ContactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        driver.findElement(By.name("middlename")).sendKeys(contact.middleName());
        driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).sendKeys(contact.home());
        driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        driver.findElement(By.name("work")).sendKeys(contact.work());
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.name("email2")).sendKeys(contact.email2());
        driver.findElement(By.name("email3")).sendKeys(contact.email3());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit)); // когда будет завершаться вызвать driver.quit()
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(967, 691));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createGroup(GroupData group) {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    public void openGroupsPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void removeGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
