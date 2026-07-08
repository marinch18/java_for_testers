package manager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    public static WebDriver driver;

    public static void createContact() {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).sendKeys("first_name");
        driver.findElement(By.name("middlename")).sendKeys("middle_name");
        driver.findElement(By.name("lastname")).sendKeys("last_name");
        driver.findElement(By.name("address")).sendKeys("address");
        driver.findElement(By.name("home")).sendKeys("123456");
        driver.findElement(By.name("mobile")).sendKeys("654321");
        driver.findElement(By.name("work")).sendKeys("777888");
        driver.findElement(By.name("email")).sendKeys("test1@mail.ru");
        driver.findElement(By.name("email2")).sendKeys("test2@mail.ru");
        driver.findElement(By.name("email3")).sendKeys("test3@mail.ru");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public static void createEmptyContact() {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).sendKeys("");
        driver.findElement(By.name("middlename")).sendKeys("");
        driver.findElement(By.name("lastname")).sendKeys("");
        driver.findElement(By.name("address")).sendKeys("");
        driver.findElement(By.name("home")).sendKeys("");
        driver.findElement(By.name("mobile")).sendKeys("");
        driver.findElement(By.name("work")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("email2")).sendKeys("");
        driver.findElement(By.name("email3")).sendKeys("");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
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

    public void createGroup(GroupData Group) {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(Group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(Group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(Group.footer());
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
