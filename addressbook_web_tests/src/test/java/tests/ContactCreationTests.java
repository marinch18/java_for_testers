package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1325, 956));
            driver.findElement(By.name("user")).click();
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test
    public void CanCreateNewContact() {
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

    @Test
    public void CanCreateNewEmptyContact() {
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
}


